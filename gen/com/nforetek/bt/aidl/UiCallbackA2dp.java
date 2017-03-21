/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\LXS\\Desktop\\BtPhone\\src\\com\\nforetek\\bt\\aidl\\UiCallbackA2dp.aidl
 */
package com.nforetek.bt.aidl;
/**
 * The callback interface for Advanced Audio Distribution Profile (A2DP).
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
 * @see INfCommandA2dp
 */
public interface UiCallbackA2dp extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.nforetek.bt.aidl.UiCallbackA2dp
{
private static final java.lang.String DESCRIPTOR = "com.nforetek.bt.aidl.UiCallbackA2dp";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.nforetek.bt.aidl.UiCallbackA2dp interface,
 * generating a proxy if needed.
 */
public static com.nforetek.bt.aidl.UiCallbackA2dp asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.nforetek.bt.aidl.UiCallbackA2dp))) {
return ((com.nforetek.bt.aidl.UiCallbackA2dp)iin);
}
return new com.nforetek.bt.aidl.UiCallbackA2dp.Stub.Proxy(obj);
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
case TRANSACTION_onA2dpServiceReady:
{
data.enforceInterface(DESCRIPTOR);
this.onA2dpServiceReady();
reply.writeNoException();
return true;
}
case TRANSACTION_onA2dpStateChanged:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.onA2dpStateChanged(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.nforetek.bt.aidl.UiCallbackA2dp
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
	 * Callback to inform A2DP Service is ready.
	 */
@Override public void onA2dpServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onA2dpServiceReady, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Callback to inform state change of A2DP connected remote device.
	 * <p>The possible values of state in this profile are: 
	 * 		<p><blockquote><b>STATE_NOT_INITIALIZED</b>	(int) 100
	 * 		<br><b>STATE_READY</b>				(int) 110
	 * 		<br><b>STATE_CONNECTING</b>			(int) 120
	 * 		<br><b>STATE_DISCONNECTING</b>		(int) 125
	 *		<br><b>STATE_CONNECTED</b>			(int) 140
	 *		<br><b>STATE_STREAMING</b>			(int) 150</blockquote>
	 * <br>The state <b>STATE_STREAMING</b> implies connected and playing.
	 * <br>Parameter address is not valid for <b>STATE_NOT_INITIALIZED</b> and <b>STATE_READY</b>.
	 * <br>It might contain unavailable content or <b>DEFAULT_ADDRESS</b> , which is 00:00:00:00:00:00.
	 *
	 * @param address Bluetooth MAC address of remote device which involves state changed.
	 * @param prevState the previous state. 
	 * @param newState the new state.
	 */
@Override public void onA2dpStateChanged(java.lang.String address, int prevState, int newState) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(prevState);
_data.writeInt(newState);
mRemote.transact(Stub.TRANSACTION_onA2dpStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onA2dpServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onA2dpStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/** 
	 * Callback to inform A2DP Service is ready.
	 */
public void onA2dpServiceReady() throws android.os.RemoteException;
/** 
	 * Callback to inform state change of A2DP connected remote device.
	 * <p>The possible values of state in this profile are: 
	 * 		<p><blockquote><b>STATE_NOT_INITIALIZED</b>	(int) 100
	 * 		<br><b>STATE_READY</b>				(int) 110
	 * 		<br><b>STATE_CONNECTING</b>			(int) 120
	 * 		<br><b>STATE_DISCONNECTING</b>		(int) 125
	 *		<br><b>STATE_CONNECTED</b>			(int) 140
	 *		<br><b>STATE_STREAMING</b>			(int) 150</blockquote>
	 * <br>The state <b>STATE_STREAMING</b> implies connected and playing.
	 * <br>Parameter address is not valid for <b>STATE_NOT_INITIALIZED</b> and <b>STATE_READY</b>.
	 * <br>It might contain unavailable content or <b>DEFAULT_ADDRESS</b> , which is 00:00:00:00:00:00.
	 *
	 * @param address Bluetooth MAC address of remote device which involves state changed.
	 * @param prevState the previous state. 
	 * @param newState the new state.
	 */
public void onA2dpStateChanged(java.lang.String address, int prevState, int newState) throws android.os.RemoteException;
}
