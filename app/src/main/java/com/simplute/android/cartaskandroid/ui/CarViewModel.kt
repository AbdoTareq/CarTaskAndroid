package com.simplute.android.cartaskandroid.ui

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.simplute.android.cartaskandroid.model.Car
import com.simplute.android.cartaskandroid.model.CarInterface
import com.simplute.android.cartaskandroid.model.ErrorStatus.Codes.getErrorMessage
import com.simplute.android.cartaskandroid.repository.CarRepository
import timber.log.Timber

enum class ApiStatus { LOADING, ERROR, DONE, EMPTY }

/**
 * ViewModel for SleepTrackerFragment.
 */
class CarViewModel(application: Application) : AndroidViewModel(application) {

    private  val pageNum = 21

    private val repo = CarRepository()
    private val applicationCon = application

    private val obj: CarInterface

    private val _status = MutableLiveData<ApiStatus>()
    val statusType: LiveData<ApiStatus>
        get() = _status

    private val _cars = MutableLiveData<List<Car>>()
    val cars: LiveData<List<Car>>
        get() = _cars

    init {
        _status.value = ApiStatus.LOADING
        obj = object : CarInterface {
            override fun onSuccess(carList: List<Car>) {
                _status.value = ApiStatus.DONE
                _cars.value = carList
            }

            override fun onFail(responseCode: String) {
                _status.value = ApiStatus.ERROR
                _cars.value = ArrayList()
                Log.e("error",getErrorMess(responseCode))
                Timber.e(getErrorMess(responseCode))
            }

        }

        getTickets()
    }

    private fun getTickets() {
        repo.getCarList(pageNum,obj)
    }

    fun getErrorMess(code: String): String {
        return getErrorMessage(code, applicationCon)
    }

    override fun onCleared() {
        super.onCleared()
        repo.cancelJob()
    }

}
