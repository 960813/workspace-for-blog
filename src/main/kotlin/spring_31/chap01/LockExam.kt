package spring_31.chap01

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock

/**
 * @Author Heli
 */

object InMemoryLockManager {
    private val lockMap = ConcurrentHashMap<String, Boolean>()

    fun putItem(item: String): Boolean {
        return lockMap.putIfAbsent(item, true)!!
    }

    fun removeItem(item: String) {
        lockMap.remove(item)
    }
}

class InMemoryLock : Lock {

    companion object {
        private const val IN_MEMORY_LOCK_NAME = "InMemoryLock"
    }

    override fun tryLock(): Boolean {
        return InMemoryLockManager.putItem(IN_MEMORY_LOCK_NAME)
    }

    override fun unlock() {
        InMemoryLockManager.removeItem(IN_MEMORY_LOCK_NAME)
    }

    override fun lock() {
        throw UnsupportedOperationException()
    }

    override fun lockInterruptibly() {
        throw UnsupportedOperationException()
    }

    override fun tryLock(time: Long, unit: TimeUnit): Boolean {
        throw UnsupportedOperationException()
    }

    override fun newCondition(): Condition {
        throw UnsupportedOperationException()
    }

}

fun main() {
    val inMemoryLock = InMemoryLock()

    // multi-thread .......
    if (inMemoryLock.tryLock()) {
        // 락 잡는데 성공
    } else {
        // 락 잡는데 실패
    }
    inMemoryLock.unlock()
    // ..
}
