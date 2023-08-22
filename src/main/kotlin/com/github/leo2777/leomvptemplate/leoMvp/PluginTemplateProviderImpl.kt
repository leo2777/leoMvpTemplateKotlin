package com.github.leo2777.leomvptemplate.leoMvp

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.leo2777.leomvptemplate.leoMvp.mvp.fragment.mvpFragmentTemplate
import com.github.leo2777.leomvptemplate.leoMvp.mvp.mvpActivityTemplate


/**
 *
 * ***********************************************************************
 *the project desc: 模版 实现类
 *this name is PluginTemplateProviderImpl
 *this from package leoMvpTemplate
 *this create by machine leo mark
 *this full time on 2023年04月13日 11:02:54
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class PluginTemplateProviderImpl: WizardTemplateProvider() {

    override fun getTemplates(): List<Template>  = listOf(
        mvpActivityTemplate,
        mvpFragmentTemplate
    )
}