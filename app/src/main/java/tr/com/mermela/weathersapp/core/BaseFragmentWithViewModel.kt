package tr.com.mermela.weathersapp.core

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

/**
 *Created by Mert Melih Aytemur on 2/11/2024.
 */
abstract class BaseFragmentWithViewModel<VM : ViewModel, VB : ViewBinding>(
   private val bindingInflater : (inflater : LayoutInflater) -> VB
) : Fragment() {

    private var _binding: VB? = null

    protected val binding: VB get() = _binding as VB

    protected lateinit var fragmentContext : Context

    protected abstract val viewModel : VM

    protected open fun initListeners() {}

    protected open fun observeEvents() {}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        observeEvents()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}