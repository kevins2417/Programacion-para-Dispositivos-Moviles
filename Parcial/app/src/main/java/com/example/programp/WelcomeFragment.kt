import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.programp.R

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        view.findViewById<Button>(R.id.category_math_button).setOnClickListener {
            startGameWithCategory("Matemáticas")
        }

        view.findViewById<Button>(R.id.category_general_button).setOnClickListener {
            startGameWithCategory("Cultura General")
        }

        view.findViewById<Button>(R.id.category_history_button).setOnClickListener {
            startGameWithCategory("Historia")
        }

        return view
    }

    private fun startGameWithCategory(category: String) {
        val questionFragment = QuestionFragment.newInstance(category)
        requireFragmentManager().beginTransaction()
            .replace(R.id.main_layout, questionFragment)
            .commit()
    }
}