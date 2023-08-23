use jni::{JNIEnv, objects::JClass};

#[no_mangle]
pub extern "system" fn Java_org_libsql_internal_Native_open(
    mut env: JNIEnv,
    _class: JClass,
    path: jni::objects::JString,
) -> jni::sys::jlong {
    let path: String = env.get_string(&path).unwrap().into();
    let db = libsql::Database::open(path);
    0
}
