package com.tregz.mvvm.main.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tregz.mvvm.R
import com.tregz.mvvm.base.BaseFragment

class AuthFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, State.VIEW_INFLATING.name)
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    companion object {
        init {
            TAG = AuthFragment::class.java.simpleName
        }

        fun getTAG() : String {
            return TAG
        }
    }
}
