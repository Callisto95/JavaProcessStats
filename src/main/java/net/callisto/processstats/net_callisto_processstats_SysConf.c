#include <jni.h>
#include <unistd.h>
#include "net_callisto_processstats_SysConf.h"

/*
 * Class:     net_callisto_processstats_SysConf
 * Method:    getCLK
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_net_callisto_processstats_SysConf_getCLK(JNIEnv *, jclass) {
	return sysconf(_SC_CLK_TCK);
}

/*
 * Class:     net_callisto_processstats_SysConf
 * Method:    getPageSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_net_callisto_processstats_SysConf_getPageSize(JNIEnv *, jclass) {
	return sysconf(_SC_PAGE_SIZE);
}
