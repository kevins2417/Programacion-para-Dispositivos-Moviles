import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.programp.R

class AnswerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_answer, container, false)

        val score = arguments?.getInt("score") ?: 0
        val totalQuestions = arguments?.getInt("totalQuestions") ?: 0

        view.findViewById<TextView>(R.id.score_text).text = "Puntuación: $score / $totalQuestions"

        view.findViewById<Button>(R.id.play_again_button).setOnClickListener {
            showWelcomeScreen()
        }

        return view
    }

    private fun showWelcomeScreen() {

        requireActivity().findViewById<TextView>(R.id.welcome_message).visibility = View.VISIBLE
        requireActivity().findViewById<Button>(R.id.category_math_button).visibility = View.VISIBLE
        requireActivity().findViewById<Button>(R.id.category_general_button).visibility = View.VISIBLE
        requireActivity().findViewById<Button>(R.id.category_history_button).visibility = View.VISIBLE

        view?.findViewById<Button>(R.id.play_again_button)?.visibility = View.GONE
        view?.findViewById<TextView>(R.id.score_text)?.visibility = View.GONE
    }


    companion object {
        fun newInstance(score: Int, totalQuestions: Int): AnswerFragment {
            val fragment = AnswerFragment()
            val args = Bundle()
            args.putInt("score", score)
            args.putInt("totalQuestions", totalQuestions)
            fragment.arguments = args
            return fragment
        }
    }
}