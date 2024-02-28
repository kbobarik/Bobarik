

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exaple.api.api.Repository
import com.exaple.api.api.Result
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ViewModelApi(private val repository: Repository): ViewModel() {

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    fun sendCodeToEmail(email:String)
    {
        viewModelScope.launch {
            repository.sendCodeEmail(email).collect{
                when(it) {
                    is Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                    is Result.Success -> {
                        _showErrorToastChannel.send(false)
                    }
                }
            }
        }
    }
}