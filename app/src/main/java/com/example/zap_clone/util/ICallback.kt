package com.example.zap_clone.util

interface ICallback {

    fun onSucess(sucessMessage: Int?)
    fun failure(failureMessage: Int?)
    fun onComplete(complete: Boolean)
}