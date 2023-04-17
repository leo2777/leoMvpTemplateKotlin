package com.github.leo2777.leomvptemplate.leoMvp.mvp

import com.android.tools.idea.npw.assetstudio.toLowerCamelCase
import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.github.leo2777.leomvptemplate.leoMvp.mvp.activity.mvpActivityTemplateRecipe


/**
 *
 * ***********************************************************************
 *the project desc: MVP 创建累
 *this name is MvpTemplate
 *this from package leoMvpTemplate
 *this create by machine leo mark
 *this full time on 2023年04月13日 14:41:22
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */

val mvpActivityTemplate
    get() = template {

        name = "MVP Template Activity"
        description = "一键创建 MVP模式 所有组（kotlin）"
        minApi = MIN_API
        category = Category.Activity
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )


        val temPackageName = stringParameter {
            name = "定义模块名字:"
            constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY)
            default = "Main"
            help = "生成MVP页面的名字（默认与Activity同名）"
        }



        val relPackageName = stringParameter {
            name = "真实模块名字（自动根据定义模块名称生成，请勿在此编写）:"
            constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY)
            default = "main"
            help = "保存在路径的名字，大写默认用 '_' 间隔开，与布局文件逻辑一致"
            suggest = { nameChangeToLowercase(temPackageName.value) }
        }

        val rootPackName = stringParameter {
            name = "Package Name(自动生成存储包名，一般情况下不建议修改)："
            constraints = listOf(Constraint.MODULE)
            default = "com.leo.mvp"
            visible = { !isNewModule }
        }

        val activityName = stringParameter {
            name = "Activity Name:"
            default = "MainActivity"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${temPackageName.value}Activity" }
        }


        val activityLayoutName = stringParameter {
            name = "Activity Layout Name:"
            default = "activity_${temPackageName.value}"
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY)
            suggest = { activityToLayout(nameChangeToLowercase(temPackageName.value)) }
        }

        val isCustomMVPName = booleanParameter {
            name = "自动创建及命名 MVP 组件 Presenter&Model&Contract? 默认选中，未选中可自定义M层，契约类，P层名字"
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
            name = "Package Name(自动生成存储包名，一般情况下不建议修改)："
            constraints = listOf(Constraint.PACKAGE)
            default = "com.leo.mvp"
            visible = { !isNewModule }
        }

        widgets(
            TextFieldWidget(temPackageName),
            TextFieldWidget(relPackageName),
            TextFieldWidget(rootPackName),
            TextFieldWidget(activityName),
            TextFieldWidget(activityLayoutName),
            CheckBoxWidget(isCustomMVPName),
            TextFieldWidget(presenterName),
            TextFieldWidget(modelName),
            TextFieldWidget(contractName),
            PackageNameWidget(packageName),
        )

        recipe = { templateData: TemplateData ->
            mvpActivityTemplateRecipe(
                templateData as ModuleTemplateData,
                temPackageName.value,
                relPackageName.value,
                packageName.value,
                activityName.value,
                activityLayoutName.value,
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