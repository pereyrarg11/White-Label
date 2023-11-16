package com.pereyrarg11.mobile.core.data.util

class MissingParamsException(vararg missingParams: String) :
    Exception("Missing param(s): ${missingParams.joinToString(", ")}")

class NoResultsFoundException : Exception("No results were found.")
