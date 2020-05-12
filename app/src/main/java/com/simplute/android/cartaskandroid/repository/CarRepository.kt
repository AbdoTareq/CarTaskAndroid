package com.simplute.android.cartaskandroid.repository

import com.simplute.android.cartaskandroid.model.CarInterface
import com.simplute.android.cartaskandroid.network.CarApiObj
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException
import timber.log.Timber
import java.net.SocketTimeoutException


class CarRepository {

    private var job = Job()

    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    fun getCarList(id: Int, carInterface: CarInterface) {

        coroutineScope.launch {
            try {
                val carList = CarApiObj.retrofitService.getCarList(id).data
                carInterface.onSuccess(carList!!)
            } catch (e: HttpException) {
                Timber.e("${e.code()}")
                carInterface.onFail("${e.code()}")
            } catch (e: SocketTimeoutException) {
                Timber.e("Timeout")
                carInterface.onFail("-2")
            } catch (e: Exception) {
                Timber.e(e)
                carInterface.onFail(e.toString())
            }
        }
    }

    fun cancelJob() {
        job.cancel()
    }
}