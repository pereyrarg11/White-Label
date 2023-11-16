package com.pereyrarg11.mobile.core.data.util

interface Converter<Input, Output> {
    fun convert(input: Input): Output
}
