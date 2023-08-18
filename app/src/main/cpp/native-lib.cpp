#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_fffemote_dances_skins_ffdiamond_util_Constant_getMainApi(
        JNIEnv *env, jclass clazz) {

    std::string hello = "https://glliterapps.space/nv/FFF470/V1/";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL

Java_com_fffemote_dances_skins_ffdiamond_util_Constant_getKey1(
        JNIEnv *env, jclass clazz) {

    std::string hello = "1s8DoonmFTauLIir";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_fffemote_dances_skins_ffdiamond_util_Constant_getKey2(
        JNIEnv *env, jclass clazz) {

    std::string hello = "bpgIWuiXfTDN0wCW";
    return env->NewStringUTF(hello.c_str());
}

