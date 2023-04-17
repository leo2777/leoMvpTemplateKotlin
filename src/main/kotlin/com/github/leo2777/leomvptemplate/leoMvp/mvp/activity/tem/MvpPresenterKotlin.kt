package com.github.leo2777.leomvptemplate.leoMvp.mvp.activity.tem




fun mvpPresenterKotlin(
    pathName:String,
    contractName: String,
    modelName : String,
    presenterName: String,
    packageName: String,
) = """

package ${packageName}.$pathName

import leo.study.lib_base.mvp.BasePresenter
import ${packageName}.${pathName}.$contractName
import ${packageName}.${pathName}.$modelName


/**
 *
 * ***********************************************************************
 * the project desc:
 *
 *
 * this name is $presenterName
 * this path is ${packageName}.${pathName}.$presenterName
 * this desc: 本自动生成代码，基于 leoMvpKotlin 框架，请添加相对应的依赖
 * this URL: https://github.com/leo2777/leo_kotlin_mvp_demo
 * ***********************************************************************
 */
 class $presenterName :BasePresenter<${contractName}.View>(),${contractName}.Presenter{
    
    // model层
    override var model: ${contractName}.Model? = ${modelName}()
 }
"""