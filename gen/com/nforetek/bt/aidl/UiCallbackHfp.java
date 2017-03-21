/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\LXS\\Desktop\\BtPhone\\src\\com\\nforetek\\bt\\aidl\\UiCallbackHfp.aidl
 */
package com.nforetek.bt.aidl;
/**
 * The callback interface for HandsFree profiles (HFP).
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
 * @see INfCommandHfp
 */
public interface UiCallbackHfp extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.nforetek.bt.aidl.UiCallbackHfp
{
private static final java.lang.String DESCRIPTOR = "com.nforetek.bt.aidl.UiCallbackHfp";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.nforetek.bt.aidl.UiCallbackHfp interface,
 * generating a proxy if needed.
 */
public static com.nforetek.bt.aidl.UiCallbackHfp asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.nforetek.bt.aidl.UiCallbackHfp))) {
return ((com.nforetek.bt.aidl.UiCallbackHfp)iin);
}
return new com.nforetek.bt.aidl.UiCallbackHfp.Stub.Proxy(obj);
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
case TRANSACTION_onHfpServiceReady:
{
data.enforceInterface(DESCRIPTOR);
this.onHfpServiceReady();
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpStateChanged:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.onHfpStateChanged(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpAudioStateChanged:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.onHfpAudioStateChanged(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpVoiceDial:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.onHfpVoiceDial(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpErrorResponse:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.onHfpErrorResponse(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpRemoteTelecomService:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.onHfpRemoteTelecomService(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpRemoteRoamingStatus:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.onHfpRemoteRoamingStatus(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpRemoteBatteryIndicator:
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
this.onHfpRemoteBatteryIndicator(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpRemoteSignalStrength:
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
this.onHfpRemoteSignalStrength(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpCallChanged:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.nforetek.bt.aidl.NfHfpClientCall _arg1;
if ((0!=data.readInt())) {
_arg1 = com.nforetek.bt.aidl.NfHfpClientCall.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.onHfpCallChanged(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_retPbapDatabaseQueryNameByNumber:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _arg3;
_arg3 = (0!=data.readInt());
this.retPbapDatabaseQueryNameByNumber(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.nforetek.bt.aidl.UiCallbackHfp
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
	 * Callback to inform HFP Service is ready.
	 */
@Override public void onHfpServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onHfpServiceReady, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Callback to inform state change of HFP connected remote device.
	 * <p>The possible values of state in this profile are: 
	 * 		<p><blockquote><b>STATE_NOT_INITIALIZED</b>			(int) 100
	 * 		<br><b>STATE_READY</b>								(int) 110
	 * 		<br><b>STATE_CONNECTING</b>							(int) 120
	 *		<br><b>STATE_CONNECTED</b>							(int) 140
	 * <br>Parameter address is not valid for <b>STATE_NOT_INITIALIZED</b> and <b>STATE_READY</b>.
	 * <br>It might contain unavailable content or <b>DEFAULT_ADDRESS</b> , which is 00:00:00:00:00:00.
	 *
	 * @param address Bluetooth MAC address of remote device which involves state changed.
	 * @param prevState the previous state. 
	 * @param newState the new state.
	 * 
     */
@Override public void onHfpStateChanged(java.lang.String address, int prevState, int newState) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(prevState);
_data.writeInt(newState);
mRemote.transact(Stub.TRANSACTION_onHfpStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Callback to inform audio state change of HFP connected remote device.
	 * <p>The possible values of state in this profile are: 
	 * 		<p><blockquote><b>STATE_NOT_INITIALIZED</b>		(int) 100
	 * 		<br><b>STATE_READY</b>							(int) 110
	 *		<br><b>STATE_CONNECTED</b>						(int) 140</blockquote>
	 * <br>Parameter address is not valid for <b>STATE_NOT_INITIALIZED</b> and <b>STATE_READY</b>.
	 * <br>It might contain unavailable content or DEFAULT_ADDRESS , which is 00:00:00:00:00:00.
	 *
	 * @param address Bluetooth MAC address of remote device.
	 * @param prevState the previous state. 
	 * @param newState the new state.
     */
@Override public void onHfpAudioStateChanged(java.lang.String address, int prevState, int newState) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(prevState);
_data.writeInt(newState);
mRemote.transact(Stub.TRANSACTION_onHfpAudioStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform voice dial status of HFP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
	 * @param isVoiceDialOn return voice dial status (True/False).
     */
@Override public void onHfpVoiceDial(java.lang.String address, boolean isVoiceDialOn) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(((isVoiceDialOn)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onHfpVoiceDial, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the error response of HFP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param code HFP error information
     */
@Override public void onHfpErrorResponse(java.lang.String address, int code) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(code);
mRemote.transact(Stub.TRANSACTION_onHfpErrorResponse, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the change on "Telecom Service" status from HFP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param isTelecomServiceOn possible value are:
	 * <p><value>=false implies no service. No Home/Roam network available.
     * <p><value>=true implies presence of service. Home/Roam network available.  
     */
@Override public void onHfpRemoteTelecomService(java.lang.String address, boolean isTelecomServiceOn) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(((isTelecomServiceOn)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onHfpRemoteTelecomService, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the change on "Roaming" status from HFP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device which involves state changed.
     * @param isRoamingOn possible value are:
     *<p><value>=false means roaming is not active.
     *<p><value>=true means a roaming is active.  
     */
@Override public void onHfpRemoteRoamingStatus(java.lang.String address, boolean isRoamingOn) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(((isRoamingOn)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onHfpRemoteRoamingStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the change on "Battery" indicator from HFP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param currentValue current battery value
     * @param maxValue maximum battery value 
     * @param minValue minimum battery value
     */
@Override public void onHfpRemoteBatteryIndicator(java.lang.String address, int currentValue, int maxValue, int minValue) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(currentValue);
_data.writeInt(maxValue);
_data.writeInt(minValue);
mRemote.transact(Stub.TRANSACTION_onHfpRemoteBatteryIndicator, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the change on "Signal" strength from HFP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param currentStrength current signal strength
     * @param maxStrength maximum signal strength  
     * @param minStrength minimum signal strength
     */
@Override public void onHfpRemoteSignalStrength(java.lang.String address, int currentStrength, int maxStrength, int minStrength) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(currentStrength);
_data.writeInt(maxStrength);
_data.writeInt(minStrength);
mRemote.transact(Stub.TRANSACTION_onHfpRemoteSignalStrength, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Callback to update active call number or/and hold number if there are any changes no matter it is multi-call or single-call.
     *
     * @param address Bluetooth MAC address of remote device which involves state changed.
     * @param call changed call
     */
@Override public void onHfpCallChanged(java.lang.String address, com.nforetek.bt.aidl.NfHfpClientCall call) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
if ((call!=null)) {
_data.writeInt(1);
call.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onHfpCallChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Customize
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapDatabaseQueryNameByNumber reqPbapDatabaseQueryNameByNumber}
	 * for remote connected device with given Bluetooth hardware address.
	 *
     * @param address Bluetooth MAC address of remote device.
     * @param target the queried phone number.     
     * @param name the corresponding name of specified phone number. This name is meaningful only if isSuccessed is true.
     * @param isSuccess indicates that if the corresponding name is retrieved. 
     */
@Override public void retPbapDatabaseQueryNameByNumber(java.lang.String address, java.lang.String target, java.lang.String name, boolean isSuccess) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(target);
_data.writeString(name);
_data.writeInt(((isSuccess)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_retPbapDatabaseQueryNameByNumber, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onHfpServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onHfpStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onHfpAudioStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onHfpVoiceDial = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onHfpErrorResponse = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_onHfpRemoteTelecomService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_onHfpRemoteRoamingStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_onHfpRemoteBatteryIndicator = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_onHfpRemoteSignalStrength = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_onHfpCallChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_retPbapDatabaseQueryNameByNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
}
/** 
	 * Callback to inform HFP Service is ready.
	 */
public void onHfpServiceReady() throws android.os.RemoteException;
/** 
	 * Callback to inform state change of HFP connected remote device.
	 * <p>The possible values of state in this profile are: 
	 * 		<p><blockquote><b>STATE_NOT_INITIALIZED</b>			(int) 100
	 * 		<br><b>STATE_READY</b>								(int) 110
	 * 		<br><b>STATE_CONNECTING</b>							(int) 120
	 *		<br><b>STATE_CONNECTED</b>							(int) 140
	 * <br>Parameter address is not valid for <b>STATE_NOT_INITIALIZED</b> and <b>STATE_READY</b>.
	 * <br>It might contain unavailable content or <b>DEFAULT_ADDRESS</b> , which is 00:00:00:00:00:00.
	 *
	 * @param address Bluetooth MAC address of remote device which involves state changed.
	 * @param prevState the previous state. 
	 * @param newState the new state.
	 * 
     */
public void onHfpStateChanged(java.lang.String address, int prevState, int newState) throws android.os.RemoteException;
/** 
	 * Callback to inform audio state change of HFP connected remote device.
	 * <p>The possible values of state in this profile are: 
	 * 		<p><blockquote><b>STATE_NOT_INITIALIZED</b>		(int) 100
	 * 		<br><b>STATE_READY</b>							(int) 110
	 *		<br><b>STATE_CONNECTED</b>						(int) 140</blockquote>
	 * <br>Parameter address is not valid for <b>STATE_NOT_INITIALIZED</b> and <b>STATE_READY</b>.
	 * <br>It might contain unavailable content or DEFAULT_ADDRESS , which is 00:00:00:00:00:00.
	 *
	 * @param address Bluetooth MAC address of remote device.
	 * @param prevState the previous state. 
	 * @param newState the new state.
     */
public void onHfpAudioStateChanged(java.lang.String address, int prevState, int newState) throws android.os.RemoteException;
/**
	 * Callback to inform voice dial status of HFP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
	 * @param isVoiceDialOn return voice dial status (True/False).
     */
public void onHfpVoiceDial(java.lang.String address, boolean isVoiceDialOn) throws android.os.RemoteException;
/**
	 * Callback to inform the error response of HFP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param code HFP error information
     */
public void onHfpErrorResponse(java.lang.String address, int code) throws android.os.RemoteException;
/**
	 * Callback to inform the change on "Telecom Service" status from HFP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param isTelecomServiceOn possible value are:
	 * <p><value>=false implies no service. No Home/Roam network available.
     * <p><value>=true implies presence of service. Home/Roam network available.  
     */
public void onHfpRemoteTelecomService(java.lang.String address, boolean isTelecomServiceOn) throws android.os.RemoteException;
/**
	 * Callback to inform the change on "Roaming" status from HFP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device which involves state changed.
     * @param isRoamingOn possible value are:
     *<p><value>=false means roaming is not active.
     *<p><value>=true means a roaming is active.  
     */
public void onHfpRemoteRoamingStatus(java.lang.String address, boolean isRoamingOn) throws android.os.RemoteException;
/**
	 * Callback to inform the change on "Battery" indicator from HFP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param currentValue current battery value
     * @param maxValue maximum battery value 
     * @param minValue minimum battery value
     */
public void onHfpRemoteBatteryIndicator(java.lang.String address, int currentValue, int maxValue, int minValue) throws android.os.RemoteException;
/**
	 * Callback to inform the change on "Signal" strength from HFP connected remote device.
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param currentStrength current signal strength
     * @param maxStrength maximum signal strength  
     * @param minStrength minimum signal strength
     */
public void onHfpRemoteSignalStrength(java.lang.String address, int currentStrength, int maxStrength, int minStrength) throws android.os.RemoteException;
/**
     * Callback to update active call number or/and hold number if there are any changes no matter it is multi-call or single-call.
     *
     * @param address Bluetooth MAC address of remote device which involves state changed.
     * @param call changed call
     */
public void onHfpCallChanged(java.lang.String address, com.nforetek.bt.aidl.NfHfpClientCall call) throws android.os.RemoteException;
// Customize
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapDatabaseQueryNameByNumber reqPbapDatabaseQueryNameByNumber}
	 * for remote connected device with given Bluetooth hardware address.
	 *
     * @param address Bluetooth MAC address of remote device.
     * @param target the queried phone number.     
     * @param name the corresponding name of specified phone number. This name is meaningful only if isSuccessed is true.
     * @param isSuccess indicates that if the corresponding name is retrieved. 
     */
public void retPbapDatabaseQueryNameByNumber(java.lang.String address, java.lang.String target, java.lang.String name, boolean isSuccess) throws android.os.RemoteException;
}
