package com.github.leo2777.leomvptemplate.leoMvp.mvp.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.ThemeData
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.github.leo2777.leomvptemplate.leoMvp.mvp.activity.tem.*


/**
 *
 * ***********************************************************************
 *the project desc: MVP模版 创建泪
 *this name is MvpActivityTemplateRepic
 *this from package leoMvpTemplate
 *this create by machine leo mark
 *this full time on 2023年04月13日 16:51:06
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */

fun RecipeExecutor.mvpActivityTemplateRecipe(
    moduleData: ModuleTemplateData,
    temPackageName: String,
    relPackageName:String,
    packageName:String,
    rootPackageName:String,
    activityName: String,
    activityLayoutName: String,
    presenterName: String,
    modelName: String,
    contractName: String,
) {
    val (_,srcOut,resOut,manifestOut) = moduleData



    val rootPackage = if (rootPackageName == packageName){ ""}else{rootPackageName}
    val absPackage = packageName.replace(rootPackageName,"")

    val mvpActivity = mvpActivityKotlin(temPackageName,relPackageName,contractName, presenterName, packageName,rootPackage)
    save(mvpActivity,srcOut.resolve("${relPackageName}/${temPackageName}Activity.kt"))

    save(mvpXml(relPackageName,packageName,activityName), resOut.resolve("layout/${activityLayoutName}.xml"))

    mergeXml(mvpManifest(relPackageName,absPackage,activityName),manifestOut.resolve("AndroidManifest.xml"))

    val mvpContract = mvpContractKotlin(relPackageName,contractName, packageName)
    save(mvpContract,srcOut.resolve("${relPackageName}/${contractName}.kt"))

    val mvpModel = mvpModelKotlin(relPackageName,contractName,modelName,packageName)
    save(mvpModel,srcOut.resolve("${relPackageName}/${modelName}.kt"))

    val mvpPresenter = mvpPresenterKotlin(relPackageName,contractName,modelName,presenterName, packageName)
    save(mvpPresenter,srcOut.resolve("${relPackageName}/${presenterName}.kt"))

}