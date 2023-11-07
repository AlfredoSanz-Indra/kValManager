package es.alfred.kvalencia.core

/**
 * @author Alfredo Sanz
 * @time 2023
 */
object Util {

    fun groupItems(items: List<Any>, theChunk: Int): List<List<Any>> {

        var result: List<List<Any>> = items.chunked(theChunk)

        return result
    }
}