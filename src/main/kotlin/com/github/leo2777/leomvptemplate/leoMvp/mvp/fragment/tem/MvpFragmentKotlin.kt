package com.github.leo2777.leomvptemplate.leoMvp.mvp.fragment.tem


/**
 *
 * ***********************************************************************
 *the project desc: Fragment基本类
 *this name is MvpActivityKotlin
 *this from package leoMvpTemplate
 *this create by machine leo mark
 *this full time on 2023年04月13日 17:16:37
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */


fun mvpFragmentKotlin(
    name: String,
    pathName: String,
    contractName: String,
    presenterName: String,
    packageName: String,
    rootPackage: String,
) = """

package ${packageName}.$pathName


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import leo.study.lib_base.mvp.BaseMvpFragment
import ${packageName}.${pathName}.$contractName
import ${packageName}.${pathName}.$presenterName
${
    if (rootPackage.isNotEmpty()) {
        "import ${rootPackage}.databinding.Fragment${name}Binding"
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
 * this name is ${name}Fragment
 * this packageName is $rootPackage
 * this path is ${packageName}.${pathName}.${name}Fragment
 * this desc: 本自动生成代码，基于 leoMvpKotlin 框架，请添加相对应的依赖
 * this URL: https://github.com/leo2777/LeoFastDevMvpKotlin
 * this template url: https://github.com/leo2777/leoMvpTemplateKotlin
 * ***********************************************************************
 */
class ${name}Fragment : BaseMvpFragment<Fragment${name}Binding,${contractName}.View,${contractName}.Presenter>(),${contractName}.View{


    override var presenter: ${contractName}.Presenter = ${presenterName}()
    
    override fun getViewBinding(inflater:LayoutInflater,container:ViewGroup?): Fragment${name}Binding {
        return Fragment${name}Binding.inflate(inflater,container,false)
    }
    
    override fun initView(view:View){
    
    }
    
    override fun lazyLoad(){
    
    }
}
"""