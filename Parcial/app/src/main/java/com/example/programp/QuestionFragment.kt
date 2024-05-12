import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.programp.R

data class Question(val text: String, val options: List<String>, val correctAnswerIndex: Int)

class QuestionFragment : Fragment() {
    private lateinit var category: String
    private lateinit var questions: List<Question>
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question, container, false)

        category = arguments?.getString("category") ?: ""
        questions = when (category) {
            "Matemáticas" -> getMathQuestions()
            "Cultura General" -> getGeneralQuestions()
            "Historia" -> getHistoryQuestions()
            else -> emptyList()
        }

        showQuestion(view)

        view.findViewById<Button>(R.id.submit_button).setOnClickListener {
            val selectedAnswerIndex = view.findViewById<LinearLayout>(R.id.options_layout).indexOfChild(it)
            if (selectedAnswerIndex != -1) {
                checkAnswer(selectedAnswerIndex)
            } else {
                Toast.makeText(requireContext(), "Por favor, seleccione una respuesta", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun showQuestion(view: View) {
        val currentQuestion = questions[currentQuestionIndex]
        view.findViewById<TextView>(R.id.question_text).text = currentQuestion.text

        val optionsLayout = view.findViewById<LinearLayout>(R.id.options_layout)
        optionsLayout.removeAllViews()

        currentQuestion.options.forEachIndexed { index, option ->
            val optionView = Button(requireContext())
            optionView.text = option
            optionView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
            optionView.setTextColor(Color.BLACK)
            optionView.setPadding(16, 8, 16, 8)
            optionView.setOnClickListener {
                checkAnswer(index)
            }
            optionsLayout.addView(optionView)
        }
    }

    private fun showFinalScore() {
        val answerFragment = AnswerFragment.newInstance(score, questions.size)
        requireFragmentManager().beginTransaction()
            .replace(R.id.main_layout, answerFragment)
            .commit()
    }

    private fun checkAnswer(selectedAnswerIndex: Int) {
        val currentQuestion = questions[currentQuestionIndex]
        val correctAnswerIndex = currentQuestion.correctAnswerIndex

        if (selectedAnswerIndex == correctAnswerIndex) {
            score++
            Toast.makeText(requireContext(), "¡Respuesta correcta!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show()
        }

        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            showQuestion(requireView())
        } else {
            showFinalScore()
        }
    }

    companion object {
        fun newInstance(category: String): QuestionFragment {
            val fragment = QuestionFragment()
            val args = Bundle()
            args.putString("category", category)
            fragment.arguments = args
            return fragment
        }
    }

    private fun getMathQuestions(): List<Question> {
        return listOf(
            Question("¿Cuánto es 2 + 2?", listOf("3", "4", "5"), 1),
            Question("¿Cuál es la raíz cuadrada de 9?", listOf("3", "4", "5"), 0),
            Question("En una urna hay 10 bolas rojas, 8 bolas azules y 6 bolas verdes. Si se extraen 3 bolas al azar, ¿cuál es la probabilidad de obtener al menos una bola de cada color?", listOf("1/12", "1/9", "1/6"), 1),
            Question("¿Cuál es el siguiente número primo después de 17?", listOf("18", "19", "20"), 1),
            Question("¿Cuál es el perímetro de un rectángulo de base 8 cm y altura 5 cm?", listOf("26 cm", "38 cm", "40 cm"), 0),
            Question("¿Cuál es el valor absoluto de -8?", listOf("8", "-8", "0"), 0),
            Question("¿Cuál es el área de un cuadrado de lado 5 cm?", listOf("25 cm²", "50 cm²", "75 cm²"), 0),
            Question("Resuelve la ecuación 2x - 5 = 11:", listOf("x = 4", "x = 8", "x = 16"), 1),
            Question("Desarrolla la expresión (a + b)²:", listOf("a² + 2ab + b²", "a² - 2ab + b²", "a² + b²"), 0),
            Question("Un tren que viaja a 80 km/h tarda 5 horas en cruzar un túnel. ¿Cuál es la longitud del túnel?", listOf("400 km", "600 km", "800 km", "1000 km"), 1),
        )
    }

    private fun getGeneralQuestions(): List<Question> {
        return listOf(
            Question("¿Cuál es la capital de Francia?", listOf("París", "Londres", "Berlín"), 0),
            Question("¿Quién pintó la Mona Lisa?", listOf("Leonardo da Vinci", "Miguel Ángel", "Rafael Sanzio"), 0),
            Question("¿Cuántos planetas hay en el Sistema Solar?", listOf("8", "9", "10"), 1),
            Question("¿Cuál es el elemento químico con el símbolo Au?", listOf("Oro", "Plata", "Cobre"), 0),
            Question("¿En qué ciudad se encuentra la Torre Eiffel?", listOf("París", "Londres", "Berlín"), 0),
            Question("¿En qué país se encuentra el Monte Everest?", listOf("China", "India", "Nepal"), 2),
            Question("¿Cuál es la capital de Australia?", listOf("Sídney", "Melbourne", "Canberra"), 1),
            Question("¿Cuál es el animal más grande del planeta?", listOf("Ballena azul", "Elefante africano", "Jirafa"), 0),
            Question("¿En qué país se encuentra la Gran Barrera de Coral?", listOf("Australia", "Indonesia", "Filipinas"), 0),
            Question("¿Cuál es el idioma más hablado del mundo?", listOf("Español", "Inglés", "Chino mandarín"), 2)
        )
    }

    private fun getHistoryQuestions(): List<Question> {
        return listOf(
            Question("¿En qué año llegó Cristóbal Colón a América?", listOf("1492", "1521", "1776"), 0),
            Question("¿En qué año comenzó la Primera Guerra Mundial?", listOf("1939", "1918", "1914"), 2),
            Question("¿Qué civilización construyó el Coliseo?", listOf("Romana", "Griega", "Egipcia"), 0),
            Question("¿Cuál fue la civilización que construyó las pirámides de Giza?", listOf("Egipcia", "Mesopotamia", "Griega"), 0),
            Question("¿Cuál fue la capital del Imperio Inca?", listOf("Machu Picchu", "Tenochtitlan", "Cuzco"), 2),
            Question("¿Quién fue el líder de la Revolución Francesa?", listOf("Napoleón Bonaparte", "Robespierre", "Luis XVI"), 0),
            Question("¿Qué evento marcó el fin de la Segunda Guerra Mundial?", listOf("La invasión de Normandía", "La bomba atómica en Hiroshima", "La rendición de Alemania"), 1),
            Question("¿En qué siglo ocurrió el Renacimiento?", listOf("XIV", "XVII", "XV y XVI"), 2),
            Question("¿En qué año cayó el Muro de Berlín?", listOf("1989", "1990", "1991"), 0),
            Question("¿Quién fue el primer hombre en pisar la luna?", listOf("Neil Armstrong", "Buzz Aldrin", "Michael Collins"), 0),
            Question("¿En qué año se creó la Organización de las Naciones Unidas (ONU)?", listOf("1945", "1950", "1948"), 1)
        )
    }
}
