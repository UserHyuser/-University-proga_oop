import java.io.FileWriter

class ProcLg() : ProgLg() {
    private var isAbstractDataType : Boolean? = null

    constructor(str: String) : this() {
        InData(str)
    }

    override fun InData(str: String) {
        creationYear = try {
            str.split(' ')[1].toInt()
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: ProcLg.creationYear\nSmall quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: ProcLg.creationYear\nWrong initial parameter \"creationYear\" (Can't convert String to Int).\n\n")
            null
        }

        mentions = try {
            str.split(' ')[2].toInt()
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: ProcLg.mentions\nSmall quantity of initial parameters.\n\n")
            null
        }
        catch (e: NumberFormatException) {
            println("Warn: ProcLg.mentions\nWrong initial parameter \"mentions\" (Can't convert String to Int).\n\n")
            null
        }

        isAbstractDataType = try {
            when (str.split(' ')[3]) {
                "0" -> false
                "1" -> true
                else -> {
                    println("Warn: ProcLg.isAbstractDataType\nWrong initial parameter \"isAbstractDataType\".\n\n")
                    null
                }
            }
        }
        catch (e: IndexOutOfBoundsException) {
            println("Warn: ProcLg.isAbstractDataType\nSmall quantity of initial parameters.\n\n")
            null
        }
    }

    override fun OutData(fileOut: FileWriter) {
        fileOut.write("Language type: Proc\n")

        if (creationYear != null) {
            fileOut.write("Year creation: $creationYear\n")
        }
        else {
            fileOut.write("Year creation: -\n")
        }

        if (NumberOfYears() != null) {
            fileOut.write("Quantity years from creation: ${NumberOfYears()}\n")
        }
        else {
            fileOut.write("Quantity years from creation: -\n")
        }

        if (mentions != null) {
            fileOut.write("Mentions in Internet: $mentions\n")
        }
        else {
            fileOut.write("Mentions in Internet: -\n")
        }

        if (isAbstractDataType != null) {
            fileOut.write("Is abstract data type: $isAbstractDataType\n\n")
        }
        else {
            fileOut.write("Is abstract data type: -\n\n")
        }

        fileOut.write("\n")

    }

//    = fileOut.write("Language type: Proc\nYear creation: $creationYear\nIs abstract data type: $isAbstractDataType\nNumber of years: ${this.NumberOfYears()}\nMentions: $mentions\n\n")
}