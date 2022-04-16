package spring_31.chap06.selfInvocation

/**
 * @Author Heli
 */
@Service
class SelfInvocation {

    fun process() {
        something()
    }

    @Transactional
    private fun something() {
        // read
        // update
        // commit
    }
}

private annotation class Transactional
private annotation class Service
