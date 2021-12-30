package com.cssolutions.dsalgo.easy

class RotationalCipher {

    @OptIn(ExperimentalStdlibApi::class)
    fun rotationalCipher(input: String, rotationFactor: Int): String {
        val alpabhetSmallKey = "abcdefghijklmnopqrstuvwxyz".toCharArray()
        val alpabhetCapKey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()
        val numKey = "1234567890".toCharArray()
        val alphaSmallCharMap = mutableMapOf<Char, Int>()
        val alphaCapCharMap = mutableMapOf<Char, Int>()
        val numCharMap = mutableMapOf<Char, Int>()
        for (i in alpabhetSmallKey.indices) alphaSmallCharMap[alpabhetSmallKey[i]] = i
        for (i in numKey.indices) numCharMap[numKey[i]] = i
        for (i in alpabhetCapKey.indices) alphaCapCharMap[alpabhetCapKey[i]] = i
        // Write your code here
        val inputCharArr = input.toCharArray()
        for (i in inputCharArr.indices) {
            if (inputCharArr[i] in 'a'..'z')
                inputCharArr[i] = alpabhetSmallKey[(alphaSmallCharMap[inputCharArr[i]]!! + rotationFactor) % 26]
            else if (inputCharArr[i] in 'A'..'Z') {
                inputCharArr[i] = alpabhetCapKey[(alphaCapCharMap[inputCharArr[i]]!! + rotationFactor) % 26]
            } else if (inputCharArr[i] in '0'..'9') {
                inputCharArr[i] = numKey[(numCharMap[inputCharArr[i]]!! + rotationFactor) % 10]
            }
        }
        return java.lang.String.valueOf(inputCharArr)
    }
}