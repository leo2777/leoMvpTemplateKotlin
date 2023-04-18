package com.github.leo2777.leomvptemplate.leoMvp.mvp.activity.tem


/**
 *
 * ***********************************************************************
 *the project desc: Activity基本类
 *this name is MvpActivityKotlin
 *this from package leoMvpTemplate
 *this create by machine leo mark
 *this full time on 2023年04月13日 17:16:37
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */


fun mvpActivityKotlin(
    name: String,
    pathName: String,
    contractName: String,
    presenterName: String,
    packageName: String,
    rootPackage: String,
) = """

package ${packageName}.$pathName


import leo.study.lib_base.mvp.BaseMvpActivity
import ${packageName}.${pathName}.$contractName
import ${packageName}.${pathName}.$presenterName
${
    if (rootPackage.isNotEmpty()) {
        "import ${rootPackage}.databinding.Activity${name}Binding"
    } else {
        ""
    }
}

/**
 *
 * ***********************************************************************
 * the project desc: 
 *
 *
 * this name is ${name}Activity
 * this packageName is $rootPackage
 * this path is ${packageName}.${pathName}.${name}Activity
 * this desc: 本自动生成代码，基于 leoMvpKotlin 框架，请添加相对应的依赖
 * this URL: https://github.com/leo2777/leo_kotlin_mvp_demo
 * ***********************************************************************
 */
class ${name}Activity : BaseMvpActivity<Activity${name}Binding,${contractName}.View,${contractName}.Presenter>(),${contractName}.View{


    override var presenter: ${contractName}.Presenter = ${presenterName}()
    
    override fun getViewBinding(): Activity${name}Binding {
        return Activity${name}Binding.inflate(layoutInflater)
    }
    
    override fun initView(){
    
    }
    
    override fun initData(){
    
    }
}
"""