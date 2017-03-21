/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\LXS\\Desktop\\BtPhone\\src\\com\\nforetek\\bt\\aidl\\UiCallbackSpp.aidl
 */
package com.nforetek.bt.aidl;
/**
 * The callback interface for Serial Port profile (SPP).
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
 * @see INfCommandSpp
 */
public interface UiCallbackSpp extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.nforetek.bt.aidl.UiCallbackSpp
{
private static final java.lang.String DESCRIPTOR = "com.nforetek.bt.aidl.UiCallbackSpp";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.nforetek.bt.aidl.UiCallbackSpp interface,
 * generating a proxy if needed.
 */
public static com.nforetek.bt.aidl.UiCallbackSpp asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.nforetek.bt.aidl.UiCallbackSpp))) {
return ((com.nforetek.bt.aidl.UiCallbackSpp)iin);
}
return new com.nforetek.bt.aidl.UiCallbackSpp.Stub.Proxy(obj);
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
case TRANSACTION_onSppServiceReady:
{
data.enforceInterface(DESCRIPTOR);
this.onSppServiceReady();
reply.writeNoException();
return true;
}
case TRANSACTION_onSppStateChanged:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.onSppStateChanged(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_onSppErrorResponse:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.onSppErrorResponse(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_retSppConnectedDeviceAddressList:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String[] _arg1;
_arg1 = data.createStringArray();
java.lang.String[] _arg2;
_arg2 = data.createStringArray();
this.retSppConnectedDeviceAddressList(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onSppDataReceived:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _arg1;
_arg1 = data.createByteArray();
this.onSppDataReceived(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onSppSendData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.onSppSendData(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onSppAppleIapAuthenticationRequest:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onSppAppleIapAuthenticationRequest(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.nforetek.bt.aidl.UiCallbackSpp
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
/* ======================================================================================================================================================== 
	 * Callback function of state changed event to Spp
	 *//** 
	 * Callback to inform SPP Service is ready.
	 */
@Override public void onSppServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onSppServiceReady, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform state change of SPP connected remote device.
	 * 
	 * The possible values of state in this profile are 
	 * 		<p><blockquote>STATE_NOT_INITIALIZED		(int) 100
	 * 		<br>STATE_READY								(int) 110
	 * 		<br>STATE_CONNECTING						(int) 120
	 * 		<br>STATE_DISCONNECTING						(int) 125
	 *		<br>STATE_CONNECTED							(int) 140</blockquote>
	 * Parameter address is only valid in state greater than STATE_READY.
	 * In state STATE_NOT_INITIALIZED and STATE_READY, parameter address might contain unavailable content or 
	 * DEFAULT_ADDRESS , which is 00:00:00:00:00:00.
	 *
	 * @param address Bluetooth MAC address of remote device which involves state changed.
	 * @param deviceName the name of remote device.
	 * @param prevState the previous state. 
	 * The value of this parameter would be the same as newState if the new state is STATE_NOT_INITIALIZED.
	 * @param newState the new state.
     */
@Override public void onSppStateChanged(java.lang.String address, java.lang.String deviceName, int prevState, int newState) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(deviceName);
_data.writeInt(prevState);
_data.writeInt(newState);
mRemote.transact(Stub.TRANSACTION_onSppStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the error response of SPP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
	 * @param errorCode the possible reason of error. 
     */
@Override public void onSppErrorResponse(java.lang.String address, int errorCode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(errorCode);
mRemote.transact(Stub.TRANSACTION_onSppErrorResponse, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform response to {@link INforeService#reqSppConnectedDeviceAddressList reqSppConnectedDeviceAddressList}
	 * Bluetooth hardware addresses would be in a format such as "00:11:22:33:AA:BB".
	 *
     * @param totalNum total number of device addresses in connected list 
     * @param addressList connected Bluetooth device address
     * @param nameList connected Bluetooth device name
     */
@Override public void retSppConnectedDeviceAddressList(int totalNum, java.lang.String[] addressList, java.lang.String[] nameList) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(totalNum);
_data.writeStringArray(addressList);
_data.writeStringArray(nameList);
mRemote.transact(Stub.TRANSACTION_retSppConnectedDeviceAddressList, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the data have been received from device with SPP connected remote device.	 
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param receivedData the data received
     */
@Override public void onSppDataReceived(java.lang.String address, byte[] receivedData) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeByteArray(receivedData);
mRemote.transact(Stub.TRANSACTION_onSppDataReceived, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the data have been sent to SPP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param length The length of data have been sent.
     */
@Override public void onSppSendData(java.lang.String address, int length) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(length);
mRemote.transact(Stub.TRANSACTION_onSppSendData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform this apple device need to do iAP authentication.
	 * Bluetooth hardware addresses would be in a format such as "00:11:22:33:AA:BB".
	 *
	 * @param address Bluetooth MAC address of remote Apple device.
     */
@Override public void onSppAppleIapAuthenticationRequest(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_onSppAppleIapAuthenticationRequest, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onSppServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onSppStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onSppErrorResponse = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_retSppConnectedDeviceAddressList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onSppDataReceived = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_onSppSendData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_onSppAppleIapAuthenticationRequest = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
}
/* ======================================================================================================================================================== 
	 * Callback function of state changed event to Spp
	 *//** 
	 * Callback to inform SPP Service is ready.
	 */
public void onSppServiceReady() throws android.os.RemoteException;
/**
	 * Callback to inform state change of SPP connected remote device.
	 * 
	 * The possible values of state in this profile are 
	 * 		<p><blockquote>STATE_NOT_INITIALIZED		(int) 100
	 * 		<br>STATE_READY								(int) 110
	 * 		<br>STATE_CONNECTING						(int) 120
	 * 		<br>STATE_DISCONNECTING						(int) 125
	 *		<br>STATE_CONNECTED							(int) 140</blockquote>
	 * Parameter address is only valid in state greater than STATE_READY.
	 * In state STATE_NOT_INITIALIZED and STATE_READY, parameter address might contain unavailable content or 
	 * DEFAULT_ADDRESS , which is 00:00:00:00:00:00.
	 *
	 * @param address Bluetooth MAC address of remote device which involves state changed.
	 * @param deviceName the name of remote device.
	 * @param prevState the previous state. 
	 * The value of this parameter would be the same as newState if the new state is STATE_NOT_INITIALIZED.
	 * @param newState the new state.
     */
public void onSppStateChanged(java.lang.String address, java.lang.String deviceName, int prevState, int newState) throws android.os.RemoteException;
/**
	 * Callback to inform the error response of SPP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
	 * @param errorCode the possible reason of error. 
     */
public void onSppErrorResponse(java.lang.String address, int errorCode) throws android.os.RemoteException;
/**
	 * Callback to inform response to {@link INforeService#reqSppConnectedDeviceAddressList reqSppConnectedDeviceAddressList}
	 * Bluetooth hardware addresses would be in a format such as "00:11:22:33:AA:BB".
	 *
     * @param totalNum total number of device addresses in connected list 
     * @param addressList connected Bluetooth device address
     * @param nameList connected Bluetooth device name
     */
public void retSppConnectedDeviceAddressList(int totalNum, java.lang.String[] addressList, java.lang.String[] nameList) throws android.os.RemoteException;
/**
	 * Callback to inform the data have been received from device with SPP connected remote device.	 
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param receivedData the data received
     */
public void onSppDataReceived(java.lang.String address, byte[] receivedData) throws android.os.RemoteException;
/**
	 * Callback to inform the data have been sent to SPP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param length The length of data have been sent.
     */
public void onSppSendData(java.lang.String address, int length) throws android.os.RemoteException;
/**
	 * Callback to inform this apple device need to do iAP authentication.
	 * Bluetooth hardware addresses would be in a format such as "00:11:22:33:AA:BB".
	 *
	 * @param address Bluetooth MAC address of remote Apple device.
     */
public void onSppAppleIapAuthenticationRequest(java.lang.String address) throws android.os.RemoteException;
}
