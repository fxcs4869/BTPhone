/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\LXS\\Desktop\\BtPhone\\src\\com\\nforetek\\bt\\aidl\\UiCallbackBluetooth.aidl
 */
package com.nforetek.bt.aidl;
/**
 * The callback interface for Bluetooth Settings Service.
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
 * @see INfCommandBluetooth
 */
public interface UiCallbackBluetooth extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.nforetek.bt.aidl.UiCallbackBluetooth
{
private static final java.lang.String DESCRIPTOR = "com.nforetek.bt.aidl.UiCallbackBluetooth";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.nforetek.bt.aidl.UiCallbackBluetooth interface,
 * generating a proxy if needed.
 */
public static com.nforetek.bt.aidl.UiCallbackBluetooth asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.nforetek.bt.aidl.UiCallbackBluetooth))) {
return ((com.nforetek.bt.aidl.UiCallbackBluetooth)iin);
}
return new com.nforetek.bt.aidl.UiCallbackBluetooth.Stub.Proxy(obj);
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
case TRANSACTION_onBluetoothServiceReady:
{
data.enforceInterface(DESCRIPTOR);
this.onBluetoothServiceReady();
reply.writeNoException();
return true;
}
case TRANSACTION_onAdapterStateChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.onAdapterStateChanged(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onAdapterDiscoverableModeChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.onAdapterDiscoverableModeChanged(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onAdapterDiscoveryStarted:
{
data.enforceInterface(DESCRIPTOR);
this.onAdapterDiscoveryStarted();
reply.writeNoException();
return true;
}
case TRANSACTION_onAdapterDiscoveryFinished:
{
data.enforceInterface(DESCRIPTOR);
this.onAdapterDiscoveryFinished();
reply.writeNoException();
return true;
}
case TRANSACTION_retPairedDevices:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String[] _arg1;
_arg1 = data.createStringArray();
java.lang.String[] _arg2;
_arg2 = data.createStringArray();
int[] _arg3;
_arg3 = data.createIntArray();
byte[] _arg4;
_arg4 = data.createByteArray();
this.retPairedDevices(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_onDeviceFound:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
byte _arg2;
_arg2 = data.readByte();
this.onDeviceFound(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onDeviceBondStateChanged:
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
this.onDeviceBondStateChanged(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_onDeviceUuidsUpdated:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.onDeviceUuidsUpdated(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onLocalAdapterNameChanged:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onLocalAdapterNameChanged(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onDeviceOutOfRange:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onDeviceOutOfRange(_arg0);
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
case TRANSACTION_onAvrcpStateChanged:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.onAvrcpStateChanged(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onBtRoleModeChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onBtRoleModeChanged(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.nforetek.bt.aidl.UiCallbackBluetooth
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
	 * Callback to inform Bluetooth Service is ready.
	 */
@Override public void onBluetoothServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onBluetoothServiceReady, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Indicate the state of the local Bluetooth adapter has changed.
     * 
	 * For Bluetooth enable and disable
	 * 		<p><blockquote><b>BT_STATE_OFF</b>	(int) 300
	 * 		<br><b>BT_STATE_TURNING_ON</b>		(int) 301
	 * 		<br><b>BT_STATE_ON</b>				(int) 302
	 *		<br><b>BT_STATE_TURNING_OFF</b>		(int) 303</blockquote>
	 * @param prevState the previous state.
	 * @param newState the new state.
	 */
@Override public void onAdapterStateChanged(int prevState, int newState) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(prevState);
_data.writeInt(newState);
mRemote.transact(Stub.TRANSACTION_onAdapterStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Indicate the scan mode of the local Bluetooth adapter has changed.
     * 
	 * <p>Scan mode value are:
	 *		<p><blockquote><b>BT_MODE_NONE</b>			(int) 310
	 *		<br><b>BT_MODE_CONNECTABLE</b>				(int) 311
	 *		<br><b>BT_MODE_CONNECTABLE_DISCOVERABLE</b>	(int) 312</blockquote>
	 *
	 * @param prevState the previous scan state.
	 * @param newState the new scan state.
	 */
@Override public void onAdapterDiscoverableModeChanged(int prevState, int newState) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(prevState);
_data.writeInt(newState);
mRemote.transact(Stub.TRANSACTION_onAdapterDiscoverableModeChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * The local Bluetooth adapter has started the remote
     * device discovery process.
     * <p>This usually involves an inquiry scan of about 12 seconds, followed
     * by a page scan of each new device to retrieve its Bluetooth name.
     * <p>Register for {@link onDeviceFound} to be notified as
     * remote Bluetooth devices are found.
     * <p>Device discovery is a heavyweight procedure. New connections to
     * remote Bluetooth devices should not be attempted while discovery is in
     * progress, and existing connections will experience limited bandwidth
     * and high latency. Use {@link INfCommandBluetooth#cancelDiscovery} to cancel an ongoing
     * discovery.
	 */
@Override public void onAdapterDiscoveryStarted() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onAdapterDiscoveryStarted, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * The local Bluetooth adapter has finished the device
     * discovery process.
	 */
@Override public void onAdapterDiscoveryFinished() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onAdapterDiscoveryFinished, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * This callback is the response to {@link INfCommandBluetooth#reqBtPairedDevices reqBtPairedDevices}.
	 *
	 * @param elements the number of paired devices returned. Since Android system only supports 7 paired devices maximal,
	 * this value would be equal to or less than 7.
	 * @param address the address of device in String type. The name, supported profiles, and possible category of n-th device of address 
	 * are placed at n-th element of name, supportProfile, and category correspondingly.
	 * @param name the name of device in String type.
	 * @param supportProfile : the supported profiles of device in int type. Possible values are
	 *		<p><blockquote><b>PROFILE_HSP</b>	(int) 1
	 *		<br><b>PROFILE_HFP</b>				(int) (1 << 1)
	 *		<br><b>PROFILE_A2DP</b>				(int) (1 << 2)
	 * 		<br><b>PROFILE_SPP</b>				(int) (1 << 3)
	 * 		<br><b>PROFILE_PBAP</b>				(int) (1 << 4)
	 *		<br><b>PROFILE_AVRCP</b>			(int) (1 << 5)
	 *		<br><b>PROFILE_FTP</b>				(int) (1 << 6)
	 *		<br><b>PROFILE_MAP</b>				(int) (1 << 7)
	 *		<br><b>PROFILE_AVRCP_13</b>			(int) (1 << 8)
	 *		<br><b>PROFILE_AVRCP_14</b>			(int) (1 << 9)
	 *		<br><b>PROFILE_PANU</b>     		(int) (1 << 10)</blockquote>
	 *	 	 	 
	 * For example, value 7 (0000 0111) means it supports HSP, HFP and A2DP. However, this parameter might be null at the first time 
	 * this device is paired because the records from local cache might be none. In this situation, system would start SDP query
	 * automatically and notify users when SDP records are gotten successfully by calling {@link INfCallbackBluetooth#onDeviceUuidsUpdated onDeviceUuidsUpdated}.
	 * User application needs to register and implement this callback function, too.     
	 * @param category the possible category or class of device. 
	 * <p>Possible values are:
	 *		<p><blockquote><b>CAT_COMPUTER</b>		(byte) 1
	 *		<br><b>CAT_PHONE</b>					(byte) (1 << 1)
	 *		<br><b>CAT_STEREO_AUDIO</b>				(byte) (1 << 2)
	 *		<br><b>CAT_MONO_AUDIO</b>				(byte) (1 << 3)</blockquote>
	 */
@Override public void retPairedDevices(int elements, java.lang.String[] address, java.lang.String[] name, int[] supportProfile, byte[] category) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(elements);
_data.writeStringArray(address);
_data.writeStringArray(name);
_data.writeIntArray(supportProfile);
_data.writeByteArray(category);
mRemote.transact(Stub.TRANSACTION_retPairedDevices, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Callback to inform a new device is found. This callback might be the response to 
	 * {@link INfCommandBluetooth#startBtDiscovery startBtDiscovery}.
	 *
	 * @param address the address of found device in String type.
	 * @param name the name of found device in String type if it is available, otherwise return null. Maybe the later updated callback will return the found name.
	 * @param category the possible category or class of found device. 
	 * <p>Possible values are
	 *		<p><blockquote><b>CAT_COMPUTER</b>		(byte) 1
	 *		<br><b>CAT_PHONE</b>					(byte) (1 << 1)
	 *		<br><b>CAT_STEREO_AUDIO</b>				(byte) (1 << 2)
	 *		<br><b>CAT_MONO_AUDIO</b>				(byte) (1 << 3)</blockquote>
	 */
@Override public void onDeviceFound(java.lang.String address, java.lang.String name, byte category) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(name);
_data.writeByte(category);
mRemote.transact(Stub.TRANSACTION_onDeviceFound, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Callback to inform bonding (pairing) state change of remote device. This callback might be the response to 
	 * {@link INfCommandBluetooth#reqBtPair reqBtPair}.
	 * 
	 * @param address the address of remote bonding device in String type.
	 * @param name the name of remote bonding device in String type.
	 * @param prevState the previous bond state.
	 * @param newState the new bond state.
	 * <p>Bond state possible values are:
	 * <blockquote><b>BOND_NONE</b> 		(int) 330
	 * <br><b>BOND_BONDING</b> 				(int) 331
	 * <br><b>BOND_BONDED</b> 				(int) 332</blockquote>
	 *
	 * <p>Possible situation are:
	 * <br>State changed from <b>BOND_NONE</b> to <b>BOND_BONDING</b> means device is pairing.
	 * <br>State changed from <b>BOND_BONDING</b> to <b>BOND_BONDED</b> means device is paired.
	 * <br>State changed from <b>BOND_BONDING</b> to <b>BOND_NONE</b> means device is pair failed.
	 * <br>State changed from <b>BOND_BONDED</b> to <b>BOND_NONE</b> means device is unpaired.	 
	 */
@Override public void onDeviceBondStateChanged(java.lang.String address, java.lang.String name, int prevState, int newState) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(name);
_data.writeInt(prevState);
_data.writeInt(newState);
mRemote.transact(Stub.TRANSACTION_onDeviceBondStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Callback to inform the supported profiles of remote device.
	 *
	 * @param address : the address of bonded device in String type.
	 * @param name : the name of bonded device in String type.
	 * @param supportProfile : the supported profiles of paired device in int type. Possible values are
	 *		<p><blockquote><b>PROFILE_HSP</b>	(int) 1
	 *		<br><b>PROFILE_HFP</b>				(int) (1 << 1)
	 *		<br><b>PROFILE_A2DP</b>				(int) (1 << 2)
	 * 		<br><b>PROFILE_SPP</b>				(int) (1 << 3)
	 * 		<br><b>PROFILE_PBAP</b>				(int) (1 << 4)
	 *		<br><b>PROFILE_AVRCP</b>			(int) (1 << 5)
	 *		<br><b>PROFILE_FTP</b>				(int) (1 << 6)
	 *		<br><b>PROFILE_MAP</b>				(int) (1 << 7)
	 *		<br><b>PROFILE_AVRCP_13</b>			(int) (1 << 8)
	 *		<br><b>PROFILE_AVRCP_14</b>			(int) (1 << 9)
	 *		<br><b>PROFILE_PANU</b>				(int) (1 << 10)</blockquote>	 	 
	 * For example, value 7 (0000 0111) means it supports HSP, HFP and A2DP.
	 */
@Override public void onDeviceUuidsUpdated(java.lang.String address, java.lang.String name, int supportProfile) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(name);
_data.writeInt(supportProfile);
mRemote.transact(Stub.TRANSACTION_onDeviceUuidsUpdated, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * The local Bluetooth adapter has changed its friendly
     * Bluetooth name.
     * <p>This name is visible to remote Bluetooth devices.
     * @param name Adapter name
     */
@Override public void onLocalAdapterNameChanged(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_onLocalAdapterNameChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the remote device is moving out of communication range.
	 *
	 * @param address the address of remote bonding device in String type.
	 */
@Override public void onDeviceOutOfRange(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_onDeviceOutOfRange, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Customize

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
@Override public void onAvrcpStateChanged(java.lang.String address, int prevState, int newState) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(prevState);
_data.writeInt(newState);
mRemote.transact(Stub.TRANSACTION_onAvrcpStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the local bluetooth role changed.
	 *
	 * @param mode the mode of Bluetooth role in integer type
	 * 		<p><blockquote><b>MODE_CAR</b>		(int) 1
	 *		<br><b>MODE_TABLET</b>				(int) 2
	 */
@Override public void onBtRoleModeChanged(int mode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(mode);
mRemote.transact(Stub.TRANSACTION_onBtRoleModeChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onBluetoothServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onAdapterStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onAdapterDiscoverableModeChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onAdapterDiscoveryStarted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onAdapterDiscoveryFinished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_retPairedDevices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_onDeviceFound = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_onDeviceBondStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_onDeviceUuidsUpdated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_onLocalAdapterNameChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_onDeviceOutOfRange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_onHfpStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_onA2dpStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_onAvrcpStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_onBtRoleModeChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
}
/** 
	 * Callback to inform Bluetooth Service is ready.
	 */
public void onBluetoothServiceReady() throws android.os.RemoteException;
/** 
	 * Indicate the state of the local Bluetooth adapter has changed.
     * 
	 * For Bluetooth enable and disable
	 * 		<p><blockquote><b>BT_STATE_OFF</b>	(int) 300
	 * 		<br><b>BT_STATE_TURNING_ON</b>		(int) 301
	 * 		<br><b>BT_STATE_ON</b>				(int) 302
	 *		<br><b>BT_STATE_TURNING_OFF</b>		(int) 303</blockquote>
	 * @param prevState the previous state.
	 * @param newState the new state.
	 */
public void onAdapterStateChanged(int prevState, int newState) throws android.os.RemoteException;
/** 
	 * Indicate the scan mode of the local Bluetooth adapter has changed.
     * 
	 * <p>Scan mode value are:
	 *		<p><blockquote><b>BT_MODE_NONE</b>			(int) 310
	 *		<br><b>BT_MODE_CONNECTABLE</b>				(int) 311
	 *		<br><b>BT_MODE_CONNECTABLE_DISCOVERABLE</b>	(int) 312</blockquote>
	 *
	 * @param prevState the previous scan state.
	 * @param newState the new scan state.
	 */
public void onAdapterDiscoverableModeChanged(int prevState, int newState) throws android.os.RemoteException;
/** 
	 * The local Bluetooth adapter has started the remote
     * device discovery process.
     * <p>This usually involves an inquiry scan of about 12 seconds, followed
     * by a page scan of each new device to retrieve its Bluetooth name.
     * <p>Register for {@link onDeviceFound} to be notified as
     * remote Bluetooth devices are found.
     * <p>Device discovery is a heavyweight procedure. New connections to
     * remote Bluetooth devices should not be attempted while discovery is in
     * progress, and existing connections will experience limited bandwidth
     * and high latency. Use {@link INfCommandBluetooth#cancelDiscovery} to cancel an ongoing
     * discovery.
	 */
public void onAdapterDiscoveryStarted() throws android.os.RemoteException;
/** 
	 * The local Bluetooth adapter has finished the device
     * discovery process.
	 */
public void onAdapterDiscoveryFinished() throws android.os.RemoteException;
/** 
	 * This callback is the response to {@link INfCommandBluetooth#reqBtPairedDevices reqBtPairedDevices}.
	 *
	 * @param elements the number of paired devices returned. Since Android system only supports 7 paired devices maximal,
	 * this value would be equal to or less than 7.
	 * @param address the address of device in String type. The name, supported profiles, and possible category of n-th device of address 
	 * are placed at n-th element of name, supportProfile, and category correspondingly.
	 * @param name the name of device in String type.
	 * @param supportProfile : the supported profiles of device in int type. Possible values are
	 *		<p><blockquote><b>PROFILE_HSP</b>	(int) 1
	 *		<br><b>PROFILE_HFP</b>				(int) (1 << 1)
	 *		<br><b>PROFILE_A2DP</b>				(int) (1 << 2)
	 * 		<br><b>PROFILE_SPP</b>				(int) (1 << 3)
	 * 		<br><b>PROFILE_PBAP</b>				(int) (1 << 4)
	 *		<br><b>PROFILE_AVRCP</b>			(int) (1 << 5)
	 *		<br><b>PROFILE_FTP</b>				(int) (1 << 6)
	 *		<br><b>PROFILE_MAP</b>				(int) (1 << 7)
	 *		<br><b>PROFILE_AVRCP_13</b>			(int) (1 << 8)
	 *		<br><b>PROFILE_AVRCP_14</b>			(int) (1 << 9)
	 *		<br><b>PROFILE_PANU</b>     		(int) (1 << 10)</blockquote>
	 *	 	 	 
	 * For example, value 7 (0000 0111) means it supports HSP, HFP and A2DP. However, this parameter might be null at the first time 
	 * this device is paired because the records from local cache might be none. In this situation, system would start SDP query
	 * automatically and notify users when SDP records are gotten successfully by calling {@link INfCallbackBluetooth#onDeviceUuidsUpdated onDeviceUuidsUpdated}.
	 * User application needs to register and implement this callback function, too.     
	 * @param category the possible category or class of device. 
	 * <p>Possible values are:
	 *		<p><blockquote><b>CAT_COMPUTER</b>		(byte) 1
	 *		<br><b>CAT_PHONE</b>					(byte) (1 << 1)
	 *		<br><b>CAT_STEREO_AUDIO</b>				(byte) (1 << 2)
	 *		<br><b>CAT_MONO_AUDIO</b>				(byte) (1 << 3)</blockquote>
	 */
public void retPairedDevices(int elements, java.lang.String[] address, java.lang.String[] name, int[] supportProfile, byte[] category) throws android.os.RemoteException;
/** 
	 * Callback to inform a new device is found. This callback might be the response to 
	 * {@link INfCommandBluetooth#startBtDiscovery startBtDiscovery}.
	 *
	 * @param address the address of found device in String type.
	 * @param name the name of found device in String type if it is available, otherwise return null. Maybe the later updated callback will return the found name.
	 * @param category the possible category or class of found device. 
	 * <p>Possible values are
	 *		<p><blockquote><b>CAT_COMPUTER</b>		(byte) 1
	 *		<br><b>CAT_PHONE</b>					(byte) (1 << 1)
	 *		<br><b>CAT_STEREO_AUDIO</b>				(byte) (1 << 2)
	 *		<br><b>CAT_MONO_AUDIO</b>				(byte) (1 << 3)</blockquote>
	 */
public void onDeviceFound(java.lang.String address, java.lang.String name, byte category) throws android.os.RemoteException;
/** 
	 * Callback to inform bonding (pairing) state change of remote device. This callback might be the response to 
	 * {@link INfCommandBluetooth#reqBtPair reqBtPair}.
	 * 
	 * @param address the address of remote bonding device in String type.
	 * @param name the name of remote bonding device in String type.
	 * @param prevState the previous bond state.
	 * @param newState the new bond state.
	 * <p>Bond state possible values are:
	 * <blockquote><b>BOND_NONE</b> 		(int) 330
	 * <br><b>BOND_BONDING</b> 				(int) 331
	 * <br><b>BOND_BONDED</b> 				(int) 332</blockquote>
	 *
	 * <p>Possible situation are:
	 * <br>State changed from <b>BOND_NONE</b> to <b>BOND_BONDING</b> means device is pairing.
	 * <br>State changed from <b>BOND_BONDING</b> to <b>BOND_BONDED</b> means device is paired.
	 * <br>State changed from <b>BOND_BONDING</b> to <b>BOND_NONE</b> means device is pair failed.
	 * <br>State changed from <b>BOND_BONDED</b> to <b>BOND_NONE</b> means device is unpaired.	 
	 */
public void onDeviceBondStateChanged(java.lang.String address, java.lang.String name, int prevState, int newState) throws android.os.RemoteException;
/** 
	 * Callback to inform the supported profiles of remote device.
	 *
	 * @param address : the address of bonded device in String type.
	 * @param name : the name of bonded device in String type.
	 * @param supportProfile : the supported profiles of paired device in int type. Possible values are
	 *		<p><blockquote><b>PROFILE_HSP</b>	(int) 1
	 *		<br><b>PROFILE_HFP</b>				(int) (1 << 1)
	 *		<br><b>PROFILE_A2DP</b>				(int) (1 << 2)
	 * 		<br><b>PROFILE_SPP</b>				(int) (1 << 3)
	 * 		<br><b>PROFILE_PBAP</b>				(int) (1 << 4)
	 *		<br><b>PROFILE_AVRCP</b>			(int) (1 << 5)
	 *		<br><b>PROFILE_FTP</b>				(int) (1 << 6)
	 *		<br><b>PROFILE_MAP</b>				(int) (1 << 7)
	 *		<br><b>PROFILE_AVRCP_13</b>			(int) (1 << 8)
	 *		<br><b>PROFILE_AVRCP_14</b>			(int) (1 << 9)
	 *		<br><b>PROFILE_PANU</b>				(int) (1 << 10)</blockquote>	 	 
	 * For example, value 7 (0000 0111) means it supports HSP, HFP and A2DP.
	 */
public void onDeviceUuidsUpdated(java.lang.String address, java.lang.String name, int supportProfile) throws android.os.RemoteException;
/**
     * The local Bluetooth adapter has changed its friendly
     * Bluetooth name.
     * <p>This name is visible to remote Bluetooth devices.
     * @param name Adapter name
     */
public void onLocalAdapterNameChanged(java.lang.String name) throws android.os.RemoteException;
/**
	 * Callback to inform the remote device is moving out of communication range.
	 *
	 * @param address the address of remote bonding device in String type.
	 */
public void onDeviceOutOfRange(java.lang.String address) throws android.os.RemoteException;
// Customize

public void onHfpStateChanged(java.lang.String address, int prevState, int newState) throws android.os.RemoteException;
public void onA2dpStateChanged(java.lang.String address, int prevState, int newState) throws android.os.RemoteException;
public void onAvrcpStateChanged(java.lang.String address, int prevState, int newState) throws android.os.RemoteException;
/**
	 * Callback to inform the local bluetooth role changed.
	 *
	 * @param mode the mode of Bluetooth role in integer type
	 * 		<p><blockquote><b>MODE_CAR</b>		(int) 1
	 *		<br><b>MODE_TABLET</b>				(int) 2
	 */
public void onBtRoleModeChanged(int mode) throws android.os.RemoteException;
}
