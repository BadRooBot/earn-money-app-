package com.blacklotus.makasibbasita.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.blacklotus.makasibbasita.R
import com.blacklotus.makasibbasita.databinding.FragmentRegisrerBinding
import com.blacklotus.makasibbasita.model.AuthService
import com.blacklotus.makasibbasita.model.LoginRequest
import com.blacklotus.makasibbasita.model.RegisterRequest
import com.blacklotus.makasibbasita.model.RegisterResponse
import com.blacklotus.makasibbasita.model.ServiceBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class regisrerFragment : Fragment() {
    private var _binding: FragmentRegisrerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegisrerBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_Register2Fragment_to_Login2Fragment)
        }
        binding.registerButton.setOnClickListener {
            val auth: AuthService = ServiceBuilder.buildService(AuthService::class.java)
            try {
              val response=  auth.register(RegisterRequest("e","p"))

//
//            val response: Call<RegisterResponse> = auth.register(RegisterRequest(
//                    binding.email.text.toString(),
//                    binding.passwordField.text.toString(),
//
//                    ))
                response.enqueue(object : retrofit2.Callback<RegisterResponse> {
                    override fun onResponse(
                        call: Call<RegisterResponse>,
                        response: retrofit2.Response<RegisterResponse>
                    ) {
                        if (response.isSuccessful) {
                            Toast.makeText(context, "Register Success", Toast.LENGTH_SHORT).show()
                            var userdata: RegisterResponse = response.body()!!
                            findNavController().navigate(R.id.action_Register2Fragment_to_Login2Fragment)
                        }
                        else {
                            Log.i("Res", "onResponse: ${response.body()}")
                        }
                    }
                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                        Toast.makeText(context, "Register Failed", Toast.LENGTH_SHORT).show()
                        Log.d("Res", t.message.toString())
                    }
                })

            }catch (e: Exception){
                Log.d("Res", e.message.toString())
            }


        }
    }


}