package com.github.leo2777.leomvptemplate.leoMvp.mvp.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.leo2777.leomvptemplate.leoMvp.mvp.common.mvpContractKotlin
import com.github.leo2777.leomvptemplate.leoMvp.mvp.common.mvpModelKotlin
import com.github.leo2777.leomvptemplate.leoMvp.mvp.common.mvpPresenterKotlin
import com.github.leo2777.leomvptemplate.leoMvp.mvp.activity.tem.mvpXml
import com.github.leo2777.leomvptemplate.leoMvp.mvp.fragment.tem.mvpFragmentKotlin


/**
 *
 * ***********************************************************************
 *the project desc: Framgent MVP 模版生成文件类
 *this name is MvpFragmentTemplateRecipe
 *this from package leoMvpTemplate
 *this create by machine leo mark
 *this full time on 2023年07月04日 10:08:52
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
fun RecipeExecutor.mvpFragmentTemplateRecipe(
    moduleData: ModuleTemplateData,
    temPackageName: String,
    relPackageName:String,
    packageName:String,
    rootPackageName:String,
    fragmentName: String,
    fragmentLayoutName: String,
    presenterName: String,
    modelName: String,
    contractName: String,
) {
    val (_,srcOut,resOut) = moduleData

    val rootPackage = if (rootPackageName == packageName){ ""}else{rootPackageName}

    val mvpFragment = mvpFragmentKotlin(temPackageName,relPackageName,contractName, presenterName, packageName,rootPackage)
    save(mvpFragment,srcOut.resolve("${relPackageName}/${temPackageName}Fragment.kt"))

    save(mvpXml(relPackageName,packageName,fragmentName), resOut.resolve("layout/${fragmentLayoutName}.xml"))

    val mvpContract = mvpContractKotlin(relPackageName,contractName, packageName)
    save(mvpContract,srcOut.resolve("${relPackageName}/${contractName}.kt"))

    val mvpModel = mvpModelKotlin(relPackageName,contractName,modelName,packageName)
    save(mvpModel,srcOut.resolve("${relPackageName}/${modelName}.kt"))

    val mvpPresenter = mvpPresenterKotlin(relPackageName,contractName,modelName,presenterName, packageName)
    save(mvpPresenter,srcOut.resolve("${relPackageName}/${presenterName}.kt"))

}