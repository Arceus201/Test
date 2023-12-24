package com.example.test.local

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class BaseRepository(
    private val mContext: CoroutineContext = Dispatchers.IO
) :
    CoroutineScope {
    val job: CompletableJob = SupervisorJob()

    protected suspend fun <T, N> doInBackground(
        action: suspend () -> T,
        result: (Any?) -> N
    ) {
        launch {
            try {
                action()
                result(action)
            } catch (throwable: Throwable) {
                result(throwable.message)
            }
        }
    }

    fun cleanUp(){
        job.cancel()
    }

    override val coroutineContext: CoroutineContext
        get() = coroutineContext + job
}
