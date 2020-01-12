package ru.dreamkas

import org.springframework.beans.TypeConverter
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.config.DependencyDescriptor
import org.springframework.beans.factory.support.DefaultListableBeanFactory

class MyBeanFactory : DefaultListableBeanFactory() {


    override fun resolveDependency(descriptor: DependencyDescriptor, requestingBeanName: String?): Any? {
        if (descriptor.dependencyType.`package`.name.contains("DatabaseService")) {
            throw  NoSuchBeanDefinitionException("No") as Throwable
        }
        return super.resolveDependency(descriptor, requestingBeanName)
    }

    override fun doResolveDependency(descriptor: DependencyDescriptor, beanName: String?, autowiredBeanNames: MutableSet<String>?, typeConverter: TypeConverter?): Any? {
        if (beanName != null && descriptor.dependencyType.simpleName.contains("DatabaseService")) {
            throw  NoSuchBeanDefinitionException(beanName)
        }
        return super.doResolveDependency(descriptor, beanName, autowiredBeanNames, typeConverter)
    }
}