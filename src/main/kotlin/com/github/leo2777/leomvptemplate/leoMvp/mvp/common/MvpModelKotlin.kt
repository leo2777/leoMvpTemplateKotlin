package com.github.leo2777.leomvptemplate.leoMvp.mvp.common


fun mvpModelKotlin(
    pathName:String,
    contractName: String,
    modelName: String,
    packageName: String,
) = """
    
    
package ${packageName}.$pathName

import leo.study.lib_base.mvp.BaseModel
import ${packageName}.${pathName}.$contractName


/**
 *
 * ***********************************************************************
 * the project desc:
 *
 *
 * this name is $modelName
 * this path is ${packageName}.${pathName}.$modelName
 * this desc: 本自动生成代码，基于 leoMvpKotlin 框架，请添加相对应的依赖
 * this URL: https://github.com/leo2777/LeoFastDevMvpKotlin
 * this template url: https://github.com/leo2777/leoMvpTemplateKotlin
 * ***********************************************************************
 */
class $modelName :BaseModel(),${contractName}.Model{
      
}
"""