package com.github.leo2777.leomvptemplate.leoMvp.mvp.fragment

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.CheckBoxWidget
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.activityToLayout
import com.android.tools.idea.wizard.template.booleanParameter
import com.android.tools.idea.wizard.template.fragmentToLayout
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template
import com.github.leo2777.leomvptemplate.leoMvp.mvp.activity.mvpActivityTemplateRecipe


/**
 *
 * ***********************************************************************
 *the project desc: Fragment MVP 模版代码
 *this name is MvpFragmentTemplate
 *this from package leoMvpTemplate
 *this create by machine leo mark
 *this full time on 2023年07月04日 09:44:53
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */

val mvpFragmentTemplate
    get() = template {

        name = "Leo Kotlin MVP Fragment"
        description = "一键创建 MVP模式（Fragment） 所有组（kotlin）"
        minApi = MIN_API
        category = Category.Fragment
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.FragmentGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )


        val temPackageName = stringParameter {
            name = "定义模块名字:"
            constraints = listOf(Constraint.NONEMPTY)
            default = "Main"
            help = "生成MVP页面的名字（默认与Fragment同名）"
        }



        val relPackageName = stringParameter {
            name = "真实模块名字（自动根据定义模块名称生成，请勿在此编写 ！！！):"
            constraints = listOf( Constraint.NONEMPTY)
            default = "main"
            enabled = {false}
            help = "保存在路径的名字，大写默认用 '_' 间隔开，与布局文件逻辑一致"
            suggest = { nameChangeToLowercase(temPackageName.value) }
        }

        val fragmentName = stringParameter {
            name = "Fragment Name:"
            default = "MainFragment"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${temPackageName.value}Fragment" }
        }


        val fragmentLayoutName = stringParameter {
            name = "Fragment Layout Name:"
            default = "fragment_${temPackageName.value}"
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY)
            suggest = { fragmentToLayout(nameChangeToLowercase(temPackageName.value)) }
        }

        val isCustomMVPName = booleanParameter {
            name = "是否自动创建及命名 MVP 组件 Presenter&Model&Contract? 默认选中，未选中可自定义M层、契约类、P层名字"
            default = true
            help =
                "是否自动创建 P层&M层&V层 ？自动创建名字固定为 'Presenter'&'Model'&'Contract'，否则 包名+'Presenter'&'Model'&'Contract'"
        }


        val presenterName = stringParameter {
            name = "Presenter Name:"
            default = "Presenter"
            constraints = listOf(Constraint.NONEMPTY)
            help = "MVP P层"
            visible = { !isCustomMVPName.value }
            suggest =
                { if (isCustomMVPName.value) "Presenter" else "${temPackageName.value}Presenter" }
        }

        val modelName = stringParameter {
            name = "Model Name:"
            default = "Model"
            constraints = listOf(Constraint.NONEMPTY)
            help = "MVP M层"
            visible = { !isCustomMVPName.value }
            suggest = { if (isCustomMVPName.value) "Model" else "${temPackageName.value}Model" }
        }


        val contractName = stringParameter {
            name = "Contract Name:"
            default = "Contract"
            constraints = listOf(Constraint.NONEMPTY)
            help = "MVP 契约类"
            visible = { !isCustomMVPName.value }
            suggest =
                { if (isCustomMVPName.value) "Contract" else "${temPackageName.value}Contract" }
        }


        val packageName = stringParameter {
            name = "Package Name(自动生成存储包名，一般情况下不建议修改):"
            constraints = listOf(Constraint.PACKAGE)
            default = "com.leo.mvp"
            visible = { !isNewModule }
        }

        val rootPackName = stringParameter {
            name = "应用包名，默认值为当前创建的路径值，需要开发者自行删减(用于创建必要文件路径，如：R文件等等)如不修改，则需自行前往每一个文件手动修改 ！！！:"
            constraints = listOf(Constraint.NONEMPTY,Constraint.PACKAGE)
            default = "com.leo.mvp"
            help = "用于创建 activity的Manifest文件代码以及基础导包，如 R文件等等"
            visible = { !isNewModule }
            suggest = {packageName.value}
        }




        widgets(
            TextFieldWidget(rootPackName),
            TextFieldWidget(temPackageName),
            TextFieldWidget(relPackageName),
            TextFieldWidget(fragmentName),
            TextFieldWidget(fragmentLayoutName),
            CheckBoxWidget(isCustomMVPName),
            TextFieldWidget(presenterName),
            TextFieldWidget(modelName),
            TextFieldWidget(contractName),
            PackageNameWidget(packageName),
        )

        recipe = { templateData: TemplateData ->
            mvpFragmentTemplateRecipe(
                templateData as ModuleTemplateData,
                temPackageName.value,
                relPackageName.value,
                packageName.value,
                rootPackName.value,
                fragmentName.value,
                fragmentLayoutName.value,
                presenterName.value,
                modelName.value,
                contractName.value
            )
        }

    }

fun nameChangeToLowercase(className: String): String {
    val array = className.toCharArray()
    val string = StringBuilder()
    array.forEach {
        if (it.isUpperCase()) {
            //第一个首字母大写的话 不加下划线
            if (string.isNotEmpty()) {
                string.append("_")
            }
            string.append(it.lowercaseChar())
        } else {
            string.append(it)
        }
    }
    return string.toString()
}