package com.example.excuserapp.utils

class NullResponseException(message: String = "Response is null"): Exception(message)
class ResponseIsFailingException(message: String = "Response is a failure"): Exception(message)