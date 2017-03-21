/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\LXS\\Desktop\\BtPhone\\src\\com\\nforetek\\bt\\aidl\\UiCallbackOpp.aidl
 */
package com.nforetek.bt.aidl;
/**
 * The callback interface for Objext Push Profile (OPP).
 * <br>UI program should implement all methods of this interface 
 * for receiving possible callbacks from nFore service.
 * <br>The naming principle of callback in this Doc is as below,
 *		<blockquote>	<b>retXXX()</b> : must be the callback of requested API.
 *		<br>			<b>onXXX()</b>  : could be the callback for updated values or the callback from requested API.</blockquote>
 *
 * <p> The constant variables in this Doc could be found and referred by importing
 * 		<br><blockquote>com.nforetek.bt.res.NfDef</blockquote>
 * <p> with prefix NfDef class name. Ex : <code>NfDef.DEFAULT_ADDRESS</code> 
 *
 * <p> Bluetooth hardware addresses would be in a format such as "00:11:22:33:AA:BB".
 *
 * @see INfCommandOpp
 */
public interface UiCallbackOpp extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.nforetek.bt.aidl.UiCallbackOpp
{
private static final java.lang.String DESCRIPTOR = "com.nforetek.bt.aidl.UiCallbackOpp";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.nforetek.bt.aidl.UiCallbackOpp interface,
 * generating a proxy if needed.
 */
public static com.nforetek.bt.aidl.UiCallbackOpp asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.nforetek.bt.aidl.UiCallbackOpp))) {
return ((com.nforetek.bt.aidl.UiCallbackOpp)iin);
}
return new com.nforetek.bt.aidl.UiCallbackOpp.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onOppServiceReady:
{
data.enforceInterface(DESCRIPTOR);
this.onOppServiceReady();
reply.writeNoException();
return true;
}
case TRANSACTION_onOppStateChanged:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.onOppStateChanged(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_onOppReceiveFileInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
this.onOppReceiveFileInfo(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_onOppReceiveProgress:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onOppReceiveProgress(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.nforetek.bt.aidl.UiCallbackOpp
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/** 
	 * Callback to inform Opp Service is ready.
	 */
@Override public void onOppServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onOppServiceReady, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Callback to inform state change of OPP connected remote device.
	 * <p>The possible values of state in this callback are 
	 * 	<blockquote><b>STATE_NOT_INITIALIZED</b>		(int) 100
	 * 	<br><b>STATE_READY</b>							(int) 110
	 *		<br><b>STATE_CONNECTED</b>						(int) 140
 	 *		<br><b>STATE_UPLOADING</b>						(int) 170</blockquote>
	 *
	 * <br>Parameter address is not valid for <b>STATE_NOT_INITIALIZED</b> and <b>STATE_READY</b>.
	 * <br>It might contain unavailable content or <b>DEFAULT_ADDRESS</b> , which is 00:00:00:00:00:00.
	 *
	 * @param address Bluetooth MAC address of remote device which involves state changed.
	 * @param prevState the previous state. 
	 * @param currentState the current state.
	 * @param reason: the reason of state changed. Possible values are
	 *		<br>REASON_OPP_SUCCESS											(int) 0
	 * 	<br>REASON_OPP_DOWNLOAD_REJECT					(int) 1
	 * 	<br>REASON_OPP_DOWNLOAD_INTERRUPTED					(int) 2
	 * 	<br>REASON_OPP_DOWNLOAD_FILEPATH_ERROR				(int) 3	
	 *
	 */
@Override public void onOppStateChanged(java.lang.String address, int preState, int currentState, int reason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(preState);
_data.writeInt(currentState);
_data.writeInt(reason);
mRemote.transact(Stub.TRANSACTION_onOppStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Callback to inform receive file information from remote device.
	 *
  	 * @param fileName the received file name
  	 * @param  fileSize the received file size
  	 * @param  deviceName the remote device name
  	 * @param  savePath the file storage path
	 */
@Override public void onOppReceiveFileInfo(java.lang.String fileName, int fileSize, java.lang.String deviceName, java.lang.String savePath) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(fileName);
_data.writeInt(fileSize);
_data.writeString(deviceName);
_data.writeString(savePath);
mRemote.transact(Stub.TRANSACTION_onOppReceiveFileInfo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Callback to inform the receive progress.
	 *
  	 * @param receivedOffset the received file offset. 	 
	 */
@Override public void onOppReceiveProgress(int receivedOffset) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(receivedOffset);
mRemote.transact(Stub.TRANSACTION_onOppReceiveProgress, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onOppServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onOppStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onOppReceiveFileInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onOppReceiveProgress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
/** 
	 * Callback to inform Opp Service is ready.
	 */
public void onOppServiceReady() throws android.os.RemoteException;
/** 
	 * Callback to inform state change of OPP connected remote device.
	 * <p>The possible values of state in this callback are 
	 * 	<blockquote><b>STATE_NOT_INITIALIZED</b>		(int) 100
	 * 	<br><b>STATE_READY</b>							(int) 110
	 *		<br><b>STATE_CONNECTED</b>						(int) 140
 	 *		<br><b>STATE_UPLOADING</b>						(int) 170</blockquote>
	 *
	 * <br>Parameter address is not valid for <b>STATE_NOT_INITIALIZED</b> and <b>STATE_READY</b>.
	 * <br>It might contain unavailable content or <b>DEFAULT_ADDRESS</b> , which is 00:00:00:00:00:00.
	 *
	 * @param address Bluetooth MAC address of remote device which involves state changed.
	 * @param prevState the previous state. 
	 * @param currentState the current state.
	 * @param reason: the reason of state changed. Possible values are
	 *		<br>REASON_OPP_SUCCESS											(int) 0
	 * 	<br>REASON_OPP_DOWNLOAD_REJECT					(int) 1
	 * 	<br>REASON_OPP_DOWNLOAD_INTERRUPTED					(int) 2
	 * 	<br>REASON_OPP_DOWNLOAD_FILEPATH_ERROR				(int) 3	
	 *
	 */
public void onOppStateChanged(java.lang.String address, int preState, int currentState, int reason) throws android.os.RemoteException;
/** 
	 * Callback to inform receive file information from remote device.
	 *
  	 * @param fileName the received file name
  	 * @param  fileSize the received file size
  	 * @param  deviceName the remote device name
  	 * @param  savePath the file storage path
	 */
public void onOppReceiveFileInfo(java.lang.String fileName, int fileSize, java.lang.String deviceName, java.lang.String savePath) throws android.os.RemoteException;
/** 
	 * Callback to inform the receive progress.
	 *
  	 * @param receivedOffset the received file offset. 	 
	 */
public void onOppReceiveProgress(int receivedOffset) throws android.os.RemoteException;
}
