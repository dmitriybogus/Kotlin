package Practice5

class ArrayListQueue<T : Any> : Queue<T> {
    private val items = ArrayList<T>()

    override fun enqueue(element: T): Boolean {
        return items.add(element)
    }

    override fun dequeue(): T? {
        return if (isEmpty) {
            null
        } else {
            items.removeAt(0)
        }
    }

    override val count: Int
        get() = items.size

    override fun peek(): T? {
        return if (isEmpty) {
            null
        } else {
            items[0]
        }
    }
}