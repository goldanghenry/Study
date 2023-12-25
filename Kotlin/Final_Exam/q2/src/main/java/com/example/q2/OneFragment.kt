import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.q2.R


// OneFragment.kt
class OneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_one, container, false)

        val textView: TextView = view.findViewById(R.id.textView)
        // MainActivity에서 전달한 데이터 받기
        val items = arguments?.getStringArray("items")
        val choices = arguments?.getBooleanArray("choices")

        Log.d("henry", "$items")
        Log.d("henry", "$choices")

        // 선택된 항목들을 텍스트 뷰에 출력
        if (items != null && choices != null) {
            val selectedItems = mutableListOf<String>()
            Log.d("henry", "$selectedItems")
            for (i in items.indices) {
                if (choices[i]) {
                    selectedItems.add(items[i])
                }
            }
            textView.text = selectedItems.joinToString(" ")
        }

        return view
    }
}