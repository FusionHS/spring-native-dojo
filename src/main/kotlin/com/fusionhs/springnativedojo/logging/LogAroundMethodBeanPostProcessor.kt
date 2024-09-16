package com.fusionhs.springnativedojo.logging

import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Component
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.time.LocalDateTime
import java.util.HashMap

@Component
class LogAroundMethodBeanPostProcessor : BeanPostProcessor {
    private val beans: MutableMap<String?, Class<*>?> = HashMap<String?, Class<*>?>()

    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
        if (bean.javaClass.getAnnotation(LogAroundMethod::class.java) != null) {
            beans.put(beanName, bean.javaClass)
        }
        return bean
    }

    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
        if (!beans.containsKey(beanName)) {
            return bean
        }
        val beanClass: Class<*> = beans[beanName]!!
        return Proxy.newProxyInstance(
            beanClass.getClassLoader(),
            beanClass.interfaces,
            InvocationHandler { proxy: Any?, method: Method?, args: Array<Any?>? ->
                try {
                    println("Started at " + LocalDateTime.now())
                    return@InvocationHandler method!!.invoke(bean, args)
                } finally {
                    println("Ended at " + LocalDateTime.now())
                }
            })
    }

}
