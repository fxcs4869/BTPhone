/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\LXS\\Desktop\\BtPhone\\src\\com\\nforetek\\bt\\aidl\\UiCommand.aidl
 */
package com.nforetek.bt.aidl;
/**
 * The API interface is for Bluetooth Settings Service.
 * <br>UI program may use these specific APIs to access nFore service.
 * <br>The naming principle of API in this doc is as follows,
 *		<blockquote><b>setXXX()</b> : 	set attributes to specific functions of nFore service.
 *		<br><b>reqXXX()</b> : 				request nFore service to implement specific function. It is an Asynchronized mode.
 *		<br><b>isXXX()</b> : 				check the current status from nFore service. It is a Synchronized mode.
 *		<br><b>getXXX()</b> : 				get the current result from nFore service. It is a Synchronized mode.</blockquote>
 *
 * <p>The constant variables in this Doc could be found and referred by importing
 * 		<br><blockquote>com.nforetek.bt.res.NfDef</blockquote>
 * <p>with prefix NfDef class name. Ex : <code>NfDef.DEFAULT_ADDRESS</code>
 *
 * <p>Valid Bluetooth hardware addresses must be in a format such as "00:11:22:33:AA:BB".
 * 
 * @see UiCallbackBluetooth
 */
public interface UiCommand extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.nforetek.bt.aidl.UiCommand
{
private static final java.lang.String DESCRIPTOR = "com.nforetek.bt.aidl.UiCommand";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.nforetek.bt.aidl.UiCommand interface,
 * generating a proxy if needed.
 */
public static com.nforetek.bt.aidl.UiCommand asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.nforetek.bt.aidl.UiCommand))) {
return ((com.nforetek.bt.aidl.UiCommand)iin);
}
return new com.nforetek.bt.aidl.UiCommand.Stub.Proxy(obj);
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
case TRANSACTION_getUiServiceVersionName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getUiServiceVersionName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_isAvrcpServiceReady:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isAvrcpServiceReady();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isA2dpServiceReady:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isA2dpServiceReady();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isSppServiceReady:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isSppServiceReady();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isBluetoothServiceReady:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isBluetoothServiceReady();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isHfpServiceReady:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isHfpServiceReady();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isHidServiceReady:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isHidServiceReady();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isPbapServiceReady:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isPbapServiceReady();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isOppServiceReady:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isOppServiceReady();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isMapServiceReady:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isMapServiceReady();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_registerA2dpCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackA2dp _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackA2dp.Stub.asInterface(data.readStrongBinder());
boolean _result = this.registerA2dpCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_unregisterA2dpCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackA2dp _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackA2dp.Stub.asInterface(data.readStrongBinder());
boolean _result = this.unregisterA2dpCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getA2dpConnectionState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getA2dpConnectionState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isA2dpConnected:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isA2dpConnected();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getA2dpConnectedAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getA2dpConnectedAddress();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_reqA2dpConnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqA2dpConnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqA2dpDisconnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqA2dpDisconnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_pauseA2dpRender:
{
data.enforceInterface(DESCRIPTOR);
this.pauseA2dpRender();
reply.writeNoException();
return true;
}
case TRANSACTION_startA2dpRender:
{
data.enforceInterface(DESCRIPTOR);
this.startA2dpRender();
reply.writeNoException();
return true;
}
case TRANSACTION_setA2dpLocalVolume:
{
data.enforceInterface(DESCRIPTOR);
float _arg0;
_arg0 = data.readFloat();
boolean _result = this.setA2dpLocalVolume(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setA2dpStreamType:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.setA2dpStreamType(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getA2dpStreamType:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getA2dpStreamType();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_registerAvrcpCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackAvrcp _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackAvrcp.Stub.asInterface(data.readStrongBinder());
boolean _result = this.registerAvrcpCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_unregisterAvrcpCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackAvrcp _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackAvrcp.Stub.asInterface(data.readStrongBinder());
boolean _result = this.unregisterAvrcpCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getAvrcpConnectionState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getAvrcpConnectionState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isAvrcpConnected:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isAvrcpConnected();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getAvrcpConnectedAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getAvrcpConnectedAddress();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_reqAvrcpConnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqAvrcpConnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpDisconnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqAvrcpDisconnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isAvrcp13Supported:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isAvrcp13Supported(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isAvrcp14Supported:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isAvrcp14Supported(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpPlay:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcpPlay();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpStop:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcpStop();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpPause:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcpPause();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpForward:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcpForward();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpBackward:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcpBackward();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpVolumeUp:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcpVolumeUp();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpVolumeDown:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcpVolumeDown();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpStartFastForward:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcpStartFastForward();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpStopFastForward:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcpStopFastForward();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpStartRewind:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcpStartRewind();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpStopRewind:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcpStopRewind();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp13GetCapabilitiesSupportEvent:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcp13GetCapabilitiesSupportEvent();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp13GetPlayerSettingAttributesList:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcp13GetPlayerSettingAttributesList();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp13GetPlayerSettingValuesList:
{
data.enforceInterface(DESCRIPTOR);
byte _arg0;
_arg0 = data.readByte();
boolean _result = this.reqAvrcp13GetPlayerSettingValuesList(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp13GetPlayerSettingCurrentValues:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcp13GetPlayerSettingCurrentValues();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp13SetPlayerSettingValue:
{
data.enforceInterface(DESCRIPTOR);
byte _arg0;
_arg0 = data.readByte();
byte _arg1;
_arg1 = data.readByte();
boolean _result = this.reqAvrcp13SetPlayerSettingValue(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp13GetElementAttributesPlaying:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcp13GetElementAttributesPlaying();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp13GetPlayStatus:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcp13GetPlayStatus();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpRegisterEventWatcher:
{
data.enforceInterface(DESCRIPTOR);
byte _arg0;
_arg0 = data.readByte();
long _arg1;
_arg1 = data.readLong();
boolean _result = this.reqAvrcpRegisterEventWatcher(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcpUnregisterEventWatcher:
{
data.enforceInterface(DESCRIPTOR);
byte _arg0;
_arg0 = data.readByte();
boolean _result = this.reqAvrcpUnregisterEventWatcher(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp13NextGroup:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcp13NextGroup();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp13PreviousGroup:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqAvrcp13PreviousGroup();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isAvrcp14BrowsingChannelEstablished:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isAvrcp14BrowsingChannelEstablished();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp14SetAddressedPlayer:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.reqAvrcp14SetAddressedPlayer(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp14SetBrowsedPlayer:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.reqAvrcp14SetBrowsedPlayer(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp14GetFolderItems:
{
data.enforceInterface(DESCRIPTOR);
byte _arg0;
_arg0 = data.readByte();
boolean _result = this.reqAvrcp14GetFolderItems(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp14ChangePath:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
long _arg1;
_arg1 = data.readLong();
byte _arg2;
_arg2 = data.readByte();
boolean _result = this.reqAvrcp14ChangePath(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp14GetItemAttributes:
{
data.enforceInterface(DESCRIPTOR);
byte _arg0;
_arg0 = data.readByte();
int _arg1;
_arg1 = data.readInt();
long _arg2;
_arg2 = data.readLong();
boolean _result = this.reqAvrcp14GetItemAttributes(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp14PlaySelectedItem:
{
data.enforceInterface(DESCRIPTOR);
byte _arg0;
_arg0 = data.readByte();
int _arg1;
_arg1 = data.readInt();
long _arg2;
_arg2 = data.readLong();
boolean _result = this.reqAvrcp14PlaySelectedItem(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp14Search:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqAvrcp14Search(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp14AddToNowPlaying:
{
data.enforceInterface(DESCRIPTOR);
byte _arg0;
_arg0 = data.readByte();
int _arg1;
_arg1 = data.readInt();
long _arg2;
_arg2 = data.readLong();
boolean _result = this.reqAvrcp14AddToNowPlaying(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqAvrcp14SetAbsoluteVolume:
{
data.enforceInterface(DESCRIPTOR);
byte _arg0;
_arg0 = data.readByte();
boolean _result = this.reqAvrcp14SetAbsoluteVolume(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_registerBtCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackBluetooth _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackBluetooth.Stub.asInterface(data.readStrongBinder());
boolean _result = this.registerBtCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_unregisterBtCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackBluetooth _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackBluetooth.Stub.asInterface(data.readStrongBinder());
boolean _result = this.unregisterBtCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getNfServiceVersionName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getNfServiceVersionName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_setBtEnable:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _result = this.setBtEnable(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setBtDiscoverableTimeout:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.setBtDiscoverableTimeout(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_startBtDiscovery:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.startBtDiscovery();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_cancelBtDiscovery:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.cancelBtDiscovery();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqBtPair:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqBtPair(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqBtUnpair:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqBtUnpair(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqBtPairedDevices:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqBtPairedDevices();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getBtLocalName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getBtLocalName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getBtRemoteDeviceName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.getBtRemoteDeviceName(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getBtLocalAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getBtLocalAddress();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_setBtLocalName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.setBtLocalName(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isBtEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isBtEnabled();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getBtState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getBtState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isBtDiscovering:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isBtDiscovering();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isBtDiscoverable:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isBtDiscoverable();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setBtAutoConnectMode:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setBtAutoConnectMode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isBtAutoConnectEnable:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isBtAutoConnectEnable();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqBtConnectHfpA2dp:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.reqBtConnectHfpA2dp(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_reqBtDisconnectAll:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.reqBtDisconnectAll();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getBtRemoteUuids:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getBtRemoteUuids(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_switchBtRoleMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.switchBtRoleMode(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getBtRoleMode:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getBtRoleMode();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_registerHfpCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackHfp _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackHfp.Stub.asInterface(data.readStrongBinder());
boolean _result = this.registerHfpCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_unregisterHfpCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackHfp _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackHfp.Stub.asInterface(data.readStrongBinder());
boolean _result = this.unregisterHfpCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getHfpConnectionState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getHfpConnectionState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isHfpConnected:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isHfpConnected();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getHfpConnectedAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getHfpConnectedAddress();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getHfpAudioConnectionState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getHfpAudioConnectionState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_reqHfpConnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqHfpConnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqHfpDisconnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqHfpDisconnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getHfpRemoteSignalStrength:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getHfpRemoteSignalStrength();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getHfpCallList:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.nforetek.bt.aidl.NfHfpClientCall> _result = this.getHfpCallList();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_isHfpRemoteOnRoaming:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isHfpRemoteOnRoaming();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getHfpRemoteBatteryIndicator:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getHfpRemoteBatteryIndicator();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isHfpRemoteTelecomServiceOn:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isHfpRemoteTelecomServiceOn();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isHfpRemoteVoiceDialOn:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isHfpRemoteVoiceDialOn();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqHfpDialCall:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqHfpDialCall(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqHfpReDial:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqHfpReDial();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqHfpMemoryDial:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqHfpMemoryDial(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqHfpAnswerCall:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.reqHfpAnswerCall(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqHfpRejectIncomingCall:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqHfpRejectIncomingCall();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqHfpTerminateCurrentCall:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqHfpTerminateCurrentCall();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqHfpSendDtmf:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqHfpSendDtmf(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqHfpAudioTransferToCarkit:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqHfpAudioTransferToCarkit();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqHfpAudioTransferToPhone:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqHfpAudioTransferToPhone();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getHfpRemoteNetworkOperator:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getHfpRemoteNetworkOperator();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getHfpRemoteSubscriberNumber:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getHfpRemoteSubscriberNumber();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_reqHfpVoiceDial:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _result = this.reqHfpVoiceDial(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_pauseHfpRender:
{
data.enforceInterface(DESCRIPTOR);
this.pauseHfpRender();
reply.writeNoException();
return true;
}
case TRANSACTION_startHfpRender:
{
data.enforceInterface(DESCRIPTOR);
this.startHfpRender();
reply.writeNoException();
return true;
}
case TRANSACTION_isHfpMicMute:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isHfpMicMute();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_muteHfpMic:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.muteHfpMic(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isHfpInBandRingtoneSupport:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isHfpInBandRingtoneSupport();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_registerPbapCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackPbap _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackPbap.Stub.asInterface(data.readStrongBinder());
boolean _result = this.registerPbapCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_unregisterPbapCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackPbap _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackPbap.Stub.asInterface(data.readStrongBinder());
boolean _result = this.unregisterPbapCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getPbapConnectionState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getPbapConnectionState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isPbapDownloading:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isPbapDownloading();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getPbapDownloadingAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getPbapDownloadingAddress();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_reqPbapDownload:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
boolean _result = this.reqPbapDownload(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqPbapDownloadRange:
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
int _arg4;
_arg4 = data.readInt();
boolean _result = this.reqPbapDownloadRange(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqPbapDownloadToDatabase:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
boolean _result = this.reqPbapDownloadToDatabase(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqPbapDownloadRangeToDatabase:
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
int _arg4;
_arg4 = data.readInt();
boolean _result = this.reqPbapDownloadRangeToDatabase(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqPbapDownloadToContactsProvider:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
boolean _result = this.reqPbapDownloadToContactsProvider(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqPbapDownloadRangeToContactsProvider:
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
int _arg4;
_arg4 = data.readInt();
boolean _result = this.reqPbapDownloadRangeToContactsProvider(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqPbapDatabaseQueryNameByNumber:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.reqPbapDatabaseQueryNameByNumber(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_reqPbapDatabaseQueryNameByPartialNumber:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.reqPbapDatabaseQueryNameByPartialNumber(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_reqPbapDatabaseAvailable:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.reqPbapDatabaseAvailable(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_reqPbapDeleteDatabaseByAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.reqPbapDeleteDatabaseByAddress(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_reqPbapCleanDatabase:
{
data.enforceInterface(DESCRIPTOR);
this.reqPbapCleanDatabase();
reply.writeNoException();
return true;
}
case TRANSACTION_reqPbapDownloadInterrupt:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqPbapDownloadInterrupt(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setPbapDownloadNotify:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.setPbapDownloadNotify(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_registerSppCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackSpp _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackSpp.Stub.asInterface(data.readStrongBinder());
boolean _result = this.registerSppCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_unregisterSppCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackSpp _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackSpp.Stub.asInterface(data.readStrongBinder());
boolean _result = this.unregisterSppCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqSppConnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqSppConnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqSppDisconnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqSppDisconnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqSppConnectedDeviceAddressList:
{
data.enforceInterface(DESCRIPTOR);
this.reqSppConnectedDeviceAddressList();
reply.writeNoException();
return true;
}
case TRANSACTION_isSppConnected:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isSppConnected(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqSppSendData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _arg1;
_arg1 = data.createByteArray();
this.reqSppSendData(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_registerHidCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackHid _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackHid.Stub.asInterface(data.readStrongBinder());
boolean _result = this.registerHidCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_unregisterHidCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackHid _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackHid.Stub.asInterface(data.readStrongBinder());
boolean _result = this.unregisterHidCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getHidConnectionState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getHidConnectionState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isHidConnected:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isHidConnected();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getHidConnectedAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getHidConnectedAddress();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_reqHidConnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqHidConnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqHidDisconnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqHidDisconnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqSendHidMouseCommand:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
boolean _result = this.reqSendHidMouseCommand(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqSendHidVirtualKeyCommand:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.reqSendHidVirtualKeyCommand(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_registerMapCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackMap _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackMap.Stub.asInterface(data.readStrongBinder());
boolean _result = this.registerMapCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_unregisterMapCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackMap _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackMap.Stub.asInterface(data.readStrongBinder());
boolean _result = this.unregisterMapCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqMapDownloadAllMessages:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _result = this.reqMapDownloadAllMessages(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqMapDownloadSingleMessage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _result = this.reqMapDownloadSingleMessage(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqMapDownloadAllMessagesToDatabase:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _result = this.reqMapDownloadAllMessagesToDatabase(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqMapDownloadSingleMessageToDatabase:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _result = this.reqMapDownloadSingleMessageToDatabase(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqMapRegisterNotification:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _result = this.reqMapRegisterNotification(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqMapUnregisterNotification:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.reqMapUnregisterNotification(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isMapNotificationRegistered:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isMapNotificationRegistered(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqMapDownloadInterrupt:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqMapDownloadInterrupt(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqMapDatabaseAvailable:
{
data.enforceInterface(DESCRIPTOR);
this.reqMapDatabaseAvailable();
reply.writeNoException();
return true;
}
case TRANSACTION_reqMapDeleteDatabaseByAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.reqMapDeleteDatabaseByAddress(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_reqMapCleanDatabase:
{
data.enforceInterface(DESCRIPTOR);
this.reqMapCleanDatabase();
reply.writeNoException();
return true;
}
case TRANSACTION_getMapCurrentState:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getMapCurrentState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getMapRegisterState:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getMapRegisterState(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_reqMapSendMessage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _result = this.reqMapSendMessage(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqMapDeleteMessage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _result = this.reqMapDeleteMessage(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqMapChangeReadStatus:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _arg3;
_arg3 = (0!=data.readInt());
boolean _result = this.reqMapChangeReadStatus(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setMapDownloadNotify:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.setMapDownloadNotify(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_registerOppCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackOpp _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackOpp.Stub.asInterface(data.readStrongBinder());
boolean _result = this.registerOppCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_unregisterOppCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackOpp _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackOpp.Stub.asInterface(data.readStrongBinder());
boolean _result = this.unregisterOppCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setOppFilePath:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.setOppFilePath(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getOppFilePath:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getOppFilePath();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_reqOppAcceptReceiveFile:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _result = this.reqOppAcceptReceiveFile(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqOppInterruptReceiveFile:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqOppInterruptReceiveFile();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setTargetAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setTargetAddress(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getTargetAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getTargetAddress();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_reqAvrcpUpdateSongStatus:
{
data.enforceInterface(DESCRIPTOR);
this.reqAvrcpUpdateSongStatus();
reply.writeNoException();
return true;
}
case TRANSACTION_isGattServiceReady:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isGattServiceReady();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_registerGattServerCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackGattServer _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackGattServer.Stub.asInterface(data.readStrongBinder());
boolean _result = this.registerGattServerCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_unregisterGattServerCallback:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.UiCallbackGattServer _arg0;
_arg0 = com.nforetek.bt.aidl.UiCallbackGattServer.Stub.asInterface(data.readStrongBinder());
boolean _result = this.unregisterGattServerCallback(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getGattServerConnectionState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getGattServerConnectionState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_reqGattServerDisconnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.reqGattServerDisconnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqGattServerBeginServiceDeclaration:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.os.ParcelUuid _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _result = this.reqGattServerBeginServiceDeclaration(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqGattServerAddCharacteristic:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelUuid _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
boolean _result = this.reqGattServerAddCharacteristic(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqGattServerAddDescriptor:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelUuid _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
boolean _result = this.reqGattServerAddDescriptor(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqGattServerEndServiceDeclaration:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqGattServerEndServiceDeclaration();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqGattServerRemoveService:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.os.ParcelUuid _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _result = this.reqGattServerRemoveService(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqGattServerClearServices:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.reqGattServerClearServices();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqGattServerListen:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _result = this.reqGattServerListen(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqGattServerSendResponse:
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
byte[] _arg4;
_arg4 = data.createByteArray();
boolean _result = this.reqGattServerSendResponse(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reqGattServerSendNotification:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.os.ParcelUuid _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
android.os.ParcelUuid _arg3;
if ((0!=data.readInt())) {
_arg3 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
boolean _arg4;
_arg4 = (0!=data.readInt());
byte[] _arg5;
_arg5 = data.createByteArray();
boolean _result = this.reqGattServerSendNotification(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getGattAddedGattServiceUuidList:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.os.ParcelUuid> _result = this.getGattAddedGattServiceUuidList();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getGattAddedGattCharacteristicUuidList:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelUuid _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.util.List<android.os.ParcelUuid> _result = this.getGattAddedGattCharacteristicUuidList(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getGattAddedGattDescriptorUuidList:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelUuid _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.os.ParcelUuid _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.util.List<android.os.ParcelUuid> _result = this.getGattAddedGattDescriptorUuidList(_arg0, _arg1);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.nforetek.bt.aidl.UiCommand
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
@Override public java.lang.String getUiServiceVersionName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getUiServiceVersionName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if AVRCP service is ready.
	 */
@Override public boolean isAvrcpServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isAvrcpServiceReady, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if A2DP service is ready.
	 */
@Override public boolean isA2dpServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isA2dpServiceReady, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if SPP service is ready.
	 */
@Override public boolean isSppServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isSppServiceReady, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if Bluetooth service is ready.
	 */
@Override public boolean isBluetoothServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isBluetoothServiceReady, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if HFP service is ready.
	 */
@Override public boolean isHfpServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isHfpServiceReady, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if HID service is ready.
	 */
@Override public boolean isHidServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isHidServiceReady, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if PBAP service is ready.
	 */
@Override public boolean isPbapServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isPbapServiceReady, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if Opp service is ready.
	 */
@Override public boolean isOppServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isOppServiceReady, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if MAP service is ready.
	 */
@Override public boolean isMapServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isMapServiceReady, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// A2DP
/** 
	 * Register callback functions for A2DP.
	 * <br>Call this function to register callback functions for A2DP.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean registerA2dpCallback(com.nforetek.bt.aidl.UiCallbackA2dp cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerA2dpCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Remove callback functions from A2DP.
     * <br>Call this function to remove previously registered callback interface for A2DP.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean unregisterA2dpCallback(com.nforetek.bt.aidl.UiCallbackA2dp cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterA2dpCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get current connection state of the remote device.
	 *
	 * @return current state of A2DP profile service.
	 */
@Override public int getA2dpConnectionState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getA2dpConnectionState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if local device is A2DP connected with remote device.
	 *
	 * @return true to indicate A2DP is connected, or false disconnected.
	 */
@Override public boolean isA2dpConnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isA2dpConnected, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the Bluetooth hardware address of A2DP connected remote device.
	 *
	 * @return Bluetooth hardware address as string if there is a connected A2DP device, or 
	 * <code>DEFAULT_ADDRESS</code> 00:00:00:00:00:00.
	 */
@Override public java.lang.String getA2dpConnectedAddress() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getA2dpConnectedAddress, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to connect A2DP to the remote device.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged} to be notified of subsequent profile state changes.
	 * 
	 * <p>There is no guarantee that A2DP will be connected and the sequence of state changed callback of profiles! 
	 * <br>This depends on the behavior of connected device.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqA2dpConnect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqA2dpConnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to disconnect A2DP to the remote device.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged} to be notified of subsequent profile state changes.
	 * 
	 * <p>There is no guarantee that A2DP will be disconnected and the sequence of state changed callback of profiles! 
	 * <br>This depends on the behavior of connected device.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqA2dpDisconnect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqA2dpDisconnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Stop send A2DP stream data to audio track.
	 */
@Override public void pauseA2dpRender() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_pauseA2dpRender, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Start send A2DP stream data to audio track.
	 */
@Override public void startA2dpRender() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_startA2dpRender, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Request to set the volume of A2DP streaming music locally.
	 * <br>This is an asynchronous call: it will return immediately.
	 *
	 * @param vol volumn level to set. The possible values are from 0.0f to 1.0f.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean setA2dpLocalVolume(float vol) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeFloat(vol);
mRemote.transact(Stub.TRANSACTION_setA2dpLocalVolume, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to set the stream type of audio system.
	 * Have to set each time after A2DP is connected.
	 * Default value is AudioManager.STREAM_MUSIC (3)
	 * If need to change stream type during A2DP connected, have to use {@link INfCommandA2dp#pauseA2dpRender pauseA2dpRender} first
	 * and then use {@link INfCommandA2dp#startA2dpRender startA2dpRender} after set stream type.
	 *
	 * <br>This is an asynchronous call: it will return immediately.
	 *
	 * @param type stream type to set.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean setA2dpStreamType(int type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(type);
mRemote.transact(Stub.TRANSACTION_setA2dpStreamType, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the current stream type of audio system.
	 *
	 * @return current stream type of audio system.
	 */
@Override public int getA2dpStreamType() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getA2dpStreamType, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// AVRCP
/** 
	 * Register callback functions for AVRCP.
	 * <br>Call this function to register callback functions for AVRCP.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean registerAvrcpCallback(com.nforetek.bt.aidl.UiCallbackAvrcp cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerAvrcpCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Remove callback functions from AVRCP.
     * <br>Call this function to remove previously registered callback interface for AVRCP.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean unregisterAvrcpCallback(com.nforetek.bt.aidl.UiCallbackAvrcp cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterAvrcpCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get current connection state of the remote device.
	 *
	 * @return current state of AVRCP profile service.
	 */
@Override public int getAvrcpConnectionState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAvrcpConnectionState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if local device is AVRCP connected with remote device.
	 *
	 * @return true to indicate AVRCP is connected, or false disconnected.
	 */
@Override public boolean isAvrcpConnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isAvrcpConnected, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the Bluetooth hardware address of AVRCP connected remote device.
	 * 
	 */
@Override public java.lang.String getAvrcpConnectedAddress() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAvrcpConnectedAddress, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to connect AVRCP to the remote device.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#onAvrcpStateChanged onAvrcpStateChanged} to be notified of subsequent profile state changes.
	 * 
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpConnect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqAvrcpConnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to disconnect AVRCP to the remote device.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#onAvrcpStateChanged onAvrcpStateChanged} to be notified of subsequent profile state changes.
	 * 	 
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpDisconnect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqAvrcpDisconnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request if AVRCP 1.3 is supported by remote device.
	 *
	 * <p>The requested address must be the paired device and is connected currently.	 
	 *
	 * @param address valid Bluetooth MAC address of paired and connected AVRCP device.
	 * @return false if the device dose not support version 1.3 or is not connected currently.  
	 */
@Override public boolean isAvrcp13Supported(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_isAvrcp13Supported, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request if AVRCP 1.4 is supported by remote device.
	 *
	 * <p>The requested address must be the paired device and is connected currently.	 
	 *
	 * @param address valid Bluetooth MAC address of paired and connected AVRCP device.
	 * @return false if the device dose not support version 1.4 or is not connected currently.  
	 */
@Override public boolean isAvrcp14Supported(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_isAvrcp14Supported, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/* ==================================================================================================================================== 
	 * AVRCP v1.0
	 *//** 
	 * Request A2DP/AVRCP connected remote device to do the "Play" operation.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged} 
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpPlay() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcpPlay, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to do the "Stop" operation.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged} 
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpStop() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcpStop, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to do the "Pause" operation.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged} 
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpPause() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcpPause, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to do the "Forward" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpForward() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcpForward, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to do the "Backward" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpBackward() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcpBackward, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to do the "Volume Up" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpVolumeUp() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcpVolumeUp, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to do the "Volume Down" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpVolumeDown() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcpVolumeDown, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to start the "Fast Forward" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpStartFastForward() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcpStartFastForward, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to stop the "Fast Forward" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpStopFastForward() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcpStopFastForward, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to start the "Rewind" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpStartRewind() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcpStartRewind, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to stop the "Rewind" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpStopRewind() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcpStopRewind, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/* ==================================================================================================================================== 
	 * AVRCP v1.3
	 *//** 
	 * Request to get the supported events of capabilities from A2DP/AVRCP connected remote device. 
	 * This is sent by CT to inquire capabilities of the peer device.
	 *
	 * <p>This requests the list of events supported by the remote device. Remote device is expected to respond with all the events supported 
	 * including the mandatory events defined in the AVRCP v1.3 specification.	 
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13CapabilitiesSupportEvent retAvrcp13CapabilitiesSupportEvent} and 
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp13GetCapabilitiesSupportEvent() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcp13GetCapabilitiesSupportEvent, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to get the supported player application setting attributes from A2DP/AVRCP connected remote device. 
	 *
	 * <p>The list of reserved player application setting attributes is provided in Appendix F of AVRCP v1.3 specification. 
	 * <br>It is expected that a target device may have additional attributes not defined as part of the specification.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13PlayerSettingAttributesList retAvrcp13PlayerSettingAttributesList} and 
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp13GetPlayerSettingAttributesList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcp13GetPlayerSettingAttributesList, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to get the set of possible values for the requested player application setting attribute 
	 * from A2DP/AVRCP connected remote device. 
	 *
	 * <p>The list of reserved player application setting attributes and their values are provided in Appendix F of AVRCP v1.3 specification. 
	 * <br>It is expected that a target device may have additional attribute values not defined as part of the specification.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13PlayerSettingValuesList retAvrcp13PlayerSettingValuesList} and 
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @param attributeId the requesting attribute ID. Possible values are:
	 * 		<blockquote><b>AVRCP_SETTING_ATTRIBUTE_ID_EQUALIZER</b>	(byte) 0x01
	 *		<br><b>AVRCP_SETTING_ATTRIBUTE_ID_REPEAT_MODE</b>			(byte) 0x02
	 *		<br><b>AVRCP_SETTING_ATTRIBUTE_ID_SHUFFLE</b>				(byte) 0x03
	 *		<br><b>AVRCP_SETTING_ATTRIBUTE_ID_SCAN</b>					(byte) 0x04</blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp13GetPlayerSettingValuesList(byte attributeId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByte(attributeId);
mRemote.transact(Stub.TRANSACTION_reqAvrcp13GetPlayerSettingValuesList, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to get the current set values from A2DP/AVRCP connected remote device
	 * for the provided player application setting attribute. 
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13PlayerSettingCurrentValues retAvrcp13PlayerSettingCurrentValues} and 
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp13GetPlayerSettingCurrentValues() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcp13GetPlayerSettingCurrentValues, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to set the player application setting of player application setting value on A2DP/AVRCP connected remote device 
	 * for the corresponding defined PlayerApplicationSettingAttribute. 
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13SetPlayerSettingValueSuccess retAvrcp13SetPlayerSettingValueSuccess} and 
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @param attributeId the requesting attribute ID. Possible values are:
	 * 		<blockquote><b>AVRCP_SETTING_ATTRIBUTE_ID_EQUALIZER</b>	(byte) 0x01
	 *		<br><b>AVRCP_SETTING_ATTRIBUTE_ID_REPEAT_MODE</b>			(byte) 0x02
	 *		<br><b>AVRCP_SETTING_ATTRIBUTE_ID_SHUFFLE</b>				(byte) 0x03
	 *		<br><b>AVRCP_SETTING_ATTRIBUTE_ID_SCAN</b>					(byte) 0x04</blockquote>
	 * @param valueId the setting value. Possible values are:
	 * 		<blockquote>For <b>AVRCP_SETTING_ATTRIBUTE_ID_EQUALIZER</b></blockquote>
	 *			<blockquote><blockquote><b>AVRCP_SETTING_VALUE_ID_EQUALIZER_OFF</b>	(byte) 0x01
	 *			<br><b>AVRCP_SETTING_VALUE_ID_EQUALIZER_ON</b>						(byte) 0x02</blockquote></blockquote>
	 *		<blockquote>For <b>AVRCP_SETTING_ATTRIBUTE_ID_REPEAT_MODE</b></blockquote>
	 *			<blockquote><blockquote><b>AVRCP_SETTING_VALUE_ID_REPEAT_OFF</b>	(byte) 0x01
	 *			<br><b>AVRCP_SETTING_VALUE_ID_REPEAT_SINGLE</b>						(byte) 0x02
	 *			<br><b>AVRCP_SETTING_VALUE_ID_REPEAT_ALL</b>						(byte) 0x03
	 *			<br><b>AVRCP_SETTING_VALUE_ID_REPEAT_GROUP</b>						(byte) 0x04</blockquote></blockquote>
	 *		<blockquote>For <b>AVRCP_SETTING_ATTRIBUTE_ID_SHUFFLE</b></blockquote>
	 *			<blockquote><blockquote><b>AVRCP_SETTING_VALUE_ID_SHUFFLE_OFF</b>	(byte) 0x01
	 *			<br><b>AVRCP_SETTING_VALUE_ID_SHUFFLE_ALL</b>						(byte) 0x02
	 *			<br><b>AVRCP_SETTING_VALUE_ID_SHUFFLE_GROUP</b>						(byte) 0x03</blockquote></blockquote>
	 *		<blockquote>For <b>AVRCP_SETTING_ATTRIBUTE_ID_SCAN</b></blockquote>
	 *			<blockquote><blockquote><b>AVRCP_SETTING_VALUE_ID_SCAN_OFF</b>		(byte) 0x01
	 *			<br><b>AVRCP_SETTING_VALUE_ID_SCAN_ALL</b>							(byte) 0x02
	 *			<br><b>AVRCP_SETTING_VALUE_ID_SCAN_GROUP</b>						(byte) 0x03</blockquote></blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp13SetPlayerSettingValue(byte attributeId, byte valueId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByte(attributeId);
_data.writeByte(valueId);
mRemote.transact(Stub.TRANSACTION_reqAvrcp13SetPlayerSettingValue, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to get the attributes of the element specified in the parameter 
	 * from A2DP/AVRCP connected remote device
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13ElementAttributesPlaying retAvrcp13ElementAttributesPlaying} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 * 
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp13GetElementAttributesPlaying() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcp13GetElementAttributesPlaying, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to get the status of the currently playing media  
	 * from A2DP/AVRCP connected remote device
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13PlayStatus retAvrcp13PlayStatus} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *	 
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp13GetPlayStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcp13GetPlayStatus, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to register with A2DP/AVRCP connected remote device
	 * to receive notifications asynchronously based on specific events occurring. 
	 * 
	 * <p>The events registered would be kept on remote device until another
	 * {@link UiCommandAvrcp#reqAvrcpUnregisterEventWatcher reqAvrcpUnregisterEventWatcher} is called.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * <blockquote>{@link UiCallbackAvrcp#onAvrcp13EventPlaybackStatusChanged onAvrcp13EventPlaybackStatusChanged},
	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventTrackChanged onAvrcp13EventTrackChanged},
	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventTrackReachedEnd onAvrcp13EventTrackReachedEnd},
	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventTrackReachedStart onAvrcp13EventTrackReachedStart},
	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventPlaybackPosChanged onAvrcp13EventPlaybackPosChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventBatteryStatusChanged onAvrcp13EventBatteryStatusChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventSystemStatusChanged onAvrcp13EventSystemStatusChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventPlayerSettingChanged onAvrcp13EventPlayerSettingChanged},
 	 * <br>v1.4
 	 * <br>{@link UiCallbackAvrcp#onAvrcp14EventNowPlayingContentChanged onAvrcp14EventNowPlayingContentChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp14EventAvailablePlayerChanged onAvrcp14EventAvailablePlayerChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp14EventAddressedPlayerChanged onAvrcp14EventAddressedPlayerChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp14EventUidsChanged onAvrcp14EventUidsChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp14EventVolumeChanged onAvrcp14EventVolumeChanged}, and
	 * <br>{@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} </blockquote>
	 * to be notified of subsequent result.
	 * <br>Each corresponding callback would be invoked once immediately after the event has been registered successfully. 
	 *
	 *  
	 * @param eventId the registering event ID. Possible values are:
	 *		<blockquote><b>AVRCP_EVENT_ID_PLAYBACK_STATUS_CHANGED</b>		(byte) 0x01
	 *		<br><b>AVRCP_EVENT_ID_TRACK_CHANGED</b>							(byte) 0x02
	 *		<br><b>AVRCP_EVENT_ID_TRACK_REACHED_END</b>						(byte) 0x03
	 *		<br><b>AVRCP_EVENT_ID_TRACK_REACHED_START</b>					(byte) 0x04
	 *		<br><b>AVRCP_EVENT_ID_PLAYBACK_POS_CHANGED</b>					(byte) 0x05
	 *		<br><b>AVRCP_EVENT_ID_BATT_STATUS_CHANGED</b>					(byte) 0x06
	 *		<br><b>AVRCP_EVENT_ID_SYSTEM_STATUS_CHANGED</b>					(byte) 0x07
	 *		<br><b>AVRCP_EVENT_ID_PLAYER_APPLICATION_SETTING_CHANGED</b>	(byte) 0x08
	 *		<br>v1.4
	 *		<br><b>AVRCP_EVENT_ID_NOW_PLAYING_CONTENT_CHANGED</b>			(byte) 0x09
	 *		<br><b>AVRCP_EVENT_ID_AVAILABLE_PLAYERS_CHANGED</b>				(byte) 0x0a
	 *		<br><b>AVRCP_EVENT_ID_ADDRESSED_PLAYER_CHANGED</b>				(byte) 0x0b
	 *		<br><b>AVRCP_EVENT_ID_UIDS_CHANGED</b>							(byte) 0x0c
	 *		<br><b>AVRCP_EVENT_ID_VOLUME_CHANGED</b>						(byte) 0x0d</blockquote>		
	 * @param interval the update interval in second. 
	 * <br>This parameter applicable only for <b>AVRCP_EVENT_ID_PLAYBACK_POS_CHANGED</b>. 
	 * For other events, this parameter is <b>ignored</b> !
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpRegisterEventWatcher(byte eventId, long interval) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByte(eventId);
_data.writeLong(interval);
mRemote.transact(Stub.TRANSACTION_reqAvrcpRegisterEventWatcher, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to unregister the specific events with A2DP/AVRCP connected remote device.
	 *
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @param eventId the unregistering event ID. Possible values are
	 *		<blockquote><b>AVRCP_EVENT_ID_PLAYBACK_STATUS_CHANGED</b>		(byte) 0x01
	 *		<br><b>AVRCP_EVENT_ID_TRACK_CHANGED</b>							(byte) 0x02
	 *		<br><b>AVRCP_EVENT_ID_TRACK_REACHED_END</b>						(byte) 0x03
	 *		<br><b>AVRCP_EVENT_ID_TRACK_REACHED_START</b>					(byte) 0x04
	 *		<br><b>AVRCP_EVENT_ID_PLAYBACK_POS_CHANGED</b>					(byte) 0x05
	 *		<br><b>AVRCP_EVENT_ID_BATT_STATUS_CHANGED</b>					(byte) 0x06
	 *		<br><b>AVRCP_EVENT_ID_SYSTEM_STATUS_CHANGED</b>					(byte) 0x07
	 *		<br><b>AVRCP_EVENT_ID_PLAYER_APPLICATION_SETTING_CHANGED</b>	(byte) 0x08
	 *		<br>v1.4	 
	 *		<br><b>AVRCP_EVENT_ID_NOW_PLAYING_CONTENT_CHANGED</b>			(byte) 0x09
	 *		<br><b>AVRCP_EVENT_ID_AVAILABLE_PLAYERS_CHANGED</b>				(byte) 0x0a
	 *		<br><b>AVRCP_EVENT_ID_ADDRESSED_PLAYER_CHANGED</b>				(byte) 0x0b
	 *		<br><b>AVRCP_EVENT_ID_UIDS_CHANGED</b>							(byte) 0x0c
	 *		<br><b>AVRCP_EVENT_ID_VOLUME_CHANGED</b>						(byte) 0x0d</blockquote>		
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcpUnregisterEventWatcher(byte eventId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByte(eventId);
mRemote.transact(Stub.TRANSACTION_reqAvrcpUnregisterEventWatcher, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to move to the first song in the next group.
	 * 
	 * <p>This is an asynchronous call: it will return immediately.
	 * 
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp13NextGroup() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcp13NextGroup, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to move to the first song in the previous group.
	 *
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp13PreviousGroup() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcp13PreviousGroup, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/* ==================================================================================================================================== 
	 * AVRCP v1.4
	 *//** 
	 * Request if A2DP/AVRCP connected remote device has browsing channel established. 
	 *
	 * @return true to indicate the remote device has browsing channel.
	 */
@Override public boolean isAvrcp14BrowsingChannelEstablished() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isAvrcp14BrowsingChannelEstablished, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to Uiorm the A2DP/AVRCP connected remote device of which media player we wishes to control.
	 * <p>The player is selected by its "Player Id".
	 * <br>When the addressed player is changed, whether locally on the remote device or explicitly by us, 
	 * the remote device shall complete notifications following the mechanism described in section 6.9.2 of AVRCP v1.4 specification. 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14SetAddressedPlayerSuccess retAvrcp14SetAddressedPlayerSuccess} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @param playerId the selected player ID of 2 octets. 
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp14SetAddressedPlayer(int playerId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(playerId);
mRemote.transact(Stub.TRANSACTION_reqAvrcp14SetAddressedPlayer, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request the A2DP/AVRCP connected remote device to route browsing commands to which player.
	 *
	 * <p>The player to which AVRCP shall route browsing commands is the browsed player. 
	 * <br>This command shall be sent successfully before any other commands are sent on the browsing channel except 
	 * {@link UiCommandAvrcp#reqAvrcp14GetFolderItems reqAvrcp14GetFolderItems}
	 * in the Media Player List scope. 
	 * <br>If the browsed player has become unavailable this command shall be sent successfully again before further commands are sent on the browsing channel. 
	 * <br>Some players may support browsing only when set as the Addressed Player.
	 * <p>The player is selected by its "Player Id".
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14SetBrowsedPlayerSuccess retAvrcp14SetBrowsedPlayerSuccess} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param playerId the selected player ID of 2 octets. 
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp14SetBrowsedPlayer(int playerId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(playerId);
mRemote.transact(Stub.TRANSACTION_reqAvrcp14SetBrowsedPlayer, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to retrieve a listing of the contents of a folder on A2DP/AVRCP connected remote device.
	 *
	 * <p>The folder is the representation of available media players, virtual file system, the last searching result, or the playing list.
	 * Should not issue this command to an empty folder.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14FolderItems retAvrcp14FolderItems} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param scopeId the requesting folder ID. Possible values are:
	 * 		<blockquote><b>AVRCP_SCOPE_ID_MEDIA_PLAYER</b>	(byte) 0x00
	 *		<br><b>AVRCP_SCOPE_ID_VFS</b>						(byte) 0x01
	 *		<br><b>AVRCP_SCOPE_ID_SEARCH</b>					(byte) 0x02
	 *		<br><b>AVRCP_SCOPE_ID_NOW_PLAYING</b>				(byte) 0x03</blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp14GetFolderItems(byte scopeId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByte(scopeId);
mRemote.transact(Stub.TRANSACTION_reqAvrcp14GetFolderItems, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to navigate the virtual filesystem on A2DP/AVRCP connected remote device. 
	 * <p>This command allows us to navigate one level up or down in the virtual filesystem.
	 * <p>Uid counters parameter is used to make sure that our uid cache is consistent with what remote device has currently. 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14ChangePathSuccess retAvrcp14ChangePathSuccess} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param uidCounter the value of uid counter we have.
	 * @param uid The UID of the folder to navigate to. This may be retrieved via a 
	 * {@link UiCommandAvrcp#reqAvrcp14GetFolderItems reqAvrcp14GetFolderItems} command. 
	 * <br>If the navigation command is "Folder Up" this field is <b>reserved</b>.	 
	 * @param direction the requesting operation on selested UID. Possible values are:
	 * 		<blockquote><b>AVRCP_FOLDER_DIRECTION_ID_UP</b>		(byte) 0x00
	 *		<br><b>AVRCP_FOLDER_DIRECTION_ID_DOWN</b>			(byte) 0x01</blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp14ChangePath(int uidCounter, long uid, byte direction) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uidCounter);
_data.writeLong(uid);
_data.writeByte(direction);
mRemote.transact(Stub.TRANSACTION_reqAvrcp14ChangePath, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to retrieve the metadata attributes for a particular media element item or folder item 
	 * on A2DP/AVRCP connected remote device. 
	 * <p>When the remote device supports this command, we shall use this command and not {@link #reqAvrcp13GetElementAttributesPlaying reqAvrcp13GetElementAttributesPlaying}. 
	 * <br>To retrieve the Metadata for the currently playing track we should register to receive Track Changed Notifications. 
	 * <br>This shall then provide the UID of the currently playing track, which can be used in the scope of the Now Playing folder.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14ItemAttributes retAvrcp14ItemAttributes} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param scopeId the requesting folder ID. Possible values are
	 *		<blockquote><b>AVRCP_SCOPE_ID_VFS</b>		(byte) 0x01
	 *		<br><b>AVRCP_SCOPE_ID_SEARCH</b>			(byte) 0x02
	 *		<br><b>AVRCP_SCOPE_ID_NOW_PLAYING</b>		(byte) 0x03</blockquote>
	 * @param uidCounter the value of uid counter we have.
	 * @param uid The UID of the media element item or folder item to return the attributes for. UID 0 shall not be used.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp14GetItemAttributes(byte scopeId, int uidCounter, long uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByte(scopeId);
_data.writeInt(uidCounter);
_data.writeLong(uid);
mRemote.transact(Stub.TRANSACTION_reqAvrcp14GetItemAttributes, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to starts playing an item indicated by the UID.
	 * It is routed to the Addressed Player. 
	 * <p>If a UID changed event has happened but not received by local yet, the previous UID counter may be sent. 
	 * In this case a failure status shall be returned.
	 * <p>Request this command with the scope parameter of 
	 *		<blockquote><b>AVRCP_SCOPE_ID_VFS</b>			(byte) 0x01 or 
	 * 		<br><b>AVRCP_SCOPE_ID_SEARCH</b>				(byte) 0x02</blockquote>
	 * shall result in the NowPlaying folder being invalidated. 
	 * <br>The old content may not be valid any more or may contain additional items. 
	 * <p>What is put in the NowPlaying folder depends on both the media player and its state, however the item selected by us shall be included.
	 * <p>Request this command with the scope parameter of 
	 * 		<blockquote><b>AVRCP_SCOPE_ID_NOW_PLAYING</b>	(byte) 0x03</blockquote>
	 * should not change the contents of the NowPlaying Folder, the only effect is that the new item is played.
	 * <p>Never request this command with the scope parameter 
	 * 		<blockquote><b>AVRCP_SCOPE_ID_MEDIA_PLAYER</b>	(byte) 0x00.</blockquote>
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14PlaySelectedItemSuccess retAvrcp14PlaySelectedItemSuccess} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param scopeId The scope in which the UID of the media element item or folder item, if supported, is valid. Possible values are
	 *		<blockquote><b>AVRCP_SCOPE_ID_VFS</b>		(byte) 0x01
	 *		<br><b>AVRCP_SCOPE_ID_SEARCH</b>			(byte) 0x02
	 *		<br><b>AVRCP_SCOPE_ID_NOW_PLAYING</b>		(byte) 0x03</blockquote>
	 * @param uidCounter the value of uid counter we have.
	 * @param uid The UID of the media element item or folder item, if supported, to be played.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp14PlaySelectedItem(byte scopeId, int uidCounter, long uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByte(scopeId);
_data.writeInt(uidCounter);
_data.writeLong(uid);
mRemote.transact(Stub.TRANSACTION_reqAvrcp14PlaySelectedItem, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to perform the basic search from the current folder and all folders below the Browsed Players virtual filesystem. 
	 * Regular expressions shall not be supported. 
	 * <br>Search results are valid until
	 * 		<blockquote>Another search request is performed or
	 *		<br>A UIDs changed notification response is received
	 * 		<br>The Browsed player is changed</blockquote>
	 * <p>The search result would contain only media element items.
	 * <br>Searching may not be supported by all players. Furthermore, searching may only be possible on some players 
	 * when they are set as the Addressed Player.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14SearchResult retAvrcp14SearchResult} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param text The string to search on in the specified character set.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp14Search(java.lang.String text) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
mRemote.transact(Stub.TRANSACTION_reqAvrcp14Search, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request A2DP/AVRCP connected remote device to add an item indicated by the UID to the NowPlaying queue. 
	 * <p>If a UID changed event has happened but not received by local yet, the previous UID counter may be sent. 
	 * In this case a failure status shall be returned.
	 * <p>Request this command with the scope parameter of 
	 *		<blockquote><b>AVRCP_SCOPE_ID_VFS</b>			(byte) 0x01
	 * 		<br><b>AVRCP_SCOPE_ID_SEARCH</b>				(byte) 0x02 or
	 * 		<br><b>AVRCP_SCOPE_ID_NOW_PLAYING</b>			(byte) 0x03</blockquote>
	 * shall result in the item being added to the NowPlaying folder on media players that support this command.
	 * <p>Never request this command with the scope parameter 
	 * 		<blockquote><b>AVRCP_SCOPE_ID_MEDIA_PLAYER</b>	(byte) 0x00.</blockquote>
	 * This command could be requested with the UID of a Folder Item if the folder is playable. 
	 * <p>The media items of that folder are added to the NowPlaying list, not the folder itself.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14AddToNowPlayingSuccess retAvrcp14AddToNowPlayingSuccess} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param scopeId The scope in which the UID of the media element item or folder item, if supported, is valid. Possible values are
	 *		<blockquote><b>AVRCP_SCOPE_ID_VFS</b>		(byte) 0x01
	 *		<br><b>AVRCP_SCOPE_ID_SEARCH</b>			(byte) 0x02
	 *		<br><b>AVRCP_SCOPE_ID_NOW_PLAYING</b>		(byte) 0x03</blockquote>
	 * @param uidCounter the value of uid counter we have.
	 * @param uid The UID of the media element item or folder item, if supported, to be played.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp14AddToNowPlaying(byte scopeId, int uidCounter, long uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByte(scopeId);
_data.writeInt(uidCounter);
_data.writeLong(uid);
mRemote.transact(Stub.TRANSACTION_reqAvrcp14AddToNowPlaying, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * By the AVRCP v1.4 specification, this command is used to set an absolute volume to be used by the rendering device. 
	 * This is in addition to the relative volume commands. 
	 * <p>It is expected that the audio sink will perform as the TG role for this command.
	 * <br>As this command specifies a percentage rather than an absolute dB level, the CT should exercise caution when sending this command.
	 * <p>It should be noted that this command is intended to alter the rendering volume on the audio sink. 
	 * <br>It is not intended to alter the volume within the audio stream. The volume level which has actually been set on the TG is returned in the response. 
	 * This is to enable the CT to deal with whatever granularity of volume control the TG provides.
	 * <p>The setting volume is represented in one octet. The top bit (bit 7) is reserved for future definition. 
	 * <br>The volume is specified as a percentage of the maximum. The value 0x0 corresponds to 0%. The value 0x7F corresponds to 100%.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14SetAbsoluteVolumeSuccess retAvrcp14SetAbsoluteVolumeSuccess} and 
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @param volume the setting volume value of octet from 0x00 to 0x7F.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqAvrcp14SetAbsoluteVolume(byte volume) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByte(volume);
mRemote.transact(Stub.TRANSACTION_reqAvrcp14SetAbsoluteVolume, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Bluetooth
/** 
	 * Register callback functions for basic Settings functions.
	 * <br>Call this function to register callback functions for nFore service.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean registerBtCallback(com.nforetek.bt.aidl.UiCallbackBluetooth cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerBtCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Remove callback functions from nFore service.
     * <br>Call this function to remove previously registered callback interface for nFore Settings service.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean unregisterBtCallback(com.nforetek.bt.aidl.UiCallbackBluetooth cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterBtCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get nFore bluetooth service version name.
	 *
	 * @return nFore Service version name.
	 */
@Override public java.lang.String getNfServiceVersionName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNfServiceVersionName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Set local Bluetooth adapter to enable or disable .
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackBluetooth#onAdapterStateChanged onAdapterStateChanged}
	 * to be notified of subsequent adapter state changes.
	 *
	 * @param enable true to enable Bluetooth adapter or false to disable.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean setBtEnable(boolean enable) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enable)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setBtEnable, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Set local Bluetooth adapter discoverable for specific duration in seconds.
	 * <br>The system default duration for discoverable might differentiate from each other in different platforms.
	 * However, it is 120 seconds in default.
	 * <br>If the duration is negative value, discoverable would be disabled.	 
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackBluetooth#onAdapterDiscoverableModeChanged onAdapterDiscoverableModeChanged}
	 * to be notified of subsequent adapter state changes.
	 * The outcomes of this setting will be:
	 * <blockquote><p><b>enabled</b> with timeout, 
	 * <br><b>disabled</b> timeout = -1
	 * <br><b>DEFAULT_DISCOVERABLE_TIMEOUT</b> timeout = null</blockquote>
	 * The <b>DEFAULT_DISCOVERABLE_TIMEOUT</b> is 120s and the maximum timeout is 300s.
	 *
	 * @param timeout the duration of discoverable in seconds
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean setBtDiscoverableTimeout(int timeout) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(timeout);
mRemote.transact(Stub.TRANSACTION_setBtDiscoverableTimeout, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Start scan process for remote devices.
	 * <br>Client should not request to start scanning twice or more in 12 seconds.
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackBluetooth#onAdapterDiscoveryStarted onAdapterDiscoveryStarted}, {@link UiCallbackBluetooth#onDeviceFound onDeviceFound}
	 * and {@link UiCallbackBluetooth#onAdapterDiscoveryFinished onAdapterDiscoveryFinished}
	 * to be notified of subsequent adapter state changes.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean startBtDiscovery() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_startBtDiscovery, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Stop scanning process for remote devices.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackBluetooth#onAdapterDiscoveryFinished onAdapterDiscoveryFinished}
	 * to be notified of subsequent adapter state changes.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean cancelBtDiscovery() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_cancelBtDiscovery, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to pair with given Bluetooth hardware address.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackBluetooth#onDeviceBondStateChanged onDeviceBondStateChanged} and {@link UiCallbackBluetooth#onDeviceUuidsUpdated onDeviceUuidsUpdated}
	 * to be notified if pairing is successful.
	 *
	 * @attention The Android system only supports 7 paired devices maximal. System would delete the first paired device automatically when
	 * the limit is reached. 
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqBtPair(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqBtPair, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to unpair with given Bluetooth hardware address.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackBluetooth#onDeviceBondStateChanged onDeviceBondStateChanged}
	 * to be notified if unpairing is successful.
	 * However, this operation only removes pairing record locally. Remote device would not be notified until pairing again.
	 * All connected or connecting profiles should be terminated before unpairing.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqBtUnpair(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqBtUnpair, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to get the paired device list.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackBluetooth#retPairedDevices retPairedDevices}
	 * to be notified of subsequent result.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqBtPairedDevices() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqBtPairedDevices, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the name of local Bluetooth adapter.
	 * <br>If there is an error, the string "UNKNOWN" would be returned.
	 *
	 * @return the String type name of local Bluetooth adapter.
	 */
@Override public java.lang.String getBtLocalName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getBtLocalName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request the name of remote Bluetooth device with given address.
	 * <br>This method would return the name announced by remote device in String type only if this remote device
	 * has been scanned before. Otherwise the empty string would be returned.
	 *	 	 
	 * @param address valid Bluetooth MAC address.	 
	 * @return the real String type name of remote device or the empty string.
	 */
@Override public java.lang.String getBtRemoteDeviceName(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_getBtRemoteDeviceName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the address of local Bluetooth adapter.
	 *
	 * @return the String type address of local Bluetooth adapter.
	 */
@Override public java.lang.String getBtLocalAddress() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getBtLocalAddress, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Set the name of local Bluetooth adapter.
	 *
	 * @param name the name to set.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean setBtLocalName(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_setBtLocalName, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Check if Bluetooth is currently enabled.
	 *
	 * @return true if the local adapter is turned on.
	 */
@Override public boolean isBtEnabled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isBtEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the current state of local Bluetooth adapter.
	 *
	 * @return int value to denote the current state. Possible values are:
	 *		<p><blockquote><b>ERROR</b>			(int) -1
	 *		<br><b>BT_STATE_OFF</b>				(int) 300
	 *		<br><b>BT_STATE_TURNING_ON</b>		(int) 301
	 *		<br><b>BT_STATE_ON</b>				(int) 302
	 *		<br><b>BT_STATE_TURNING_OFF</b>		(int) 303</blockquote>	
	 */
@Override public int getBtState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getBtState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if Bluetooth is currently scanning remote devices.
	 *
	 * @return true if scanning.
	 */
@Override public boolean isBtDiscovering() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isBtDiscovering, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if Bluetooth is currently discoverable from remote devices.
	 *
	 * @return true if discoverable.
	 */
@Override public boolean isBtDiscoverable() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isBtDiscoverable, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Set auto connect mode as enabled or disabled.
	 * <br>Auto-connect only applies to HSP, HFP, A2DP and AVRCP services when out of range and ACC on/off events take place.
	 * Besides, only one of HSP or HFP would be re-connected, and HFP is preferred to HSP.
	 * <br>Auto-connect only applies to the following conditions: 
	 *		<blockquote><p>there is an out of range event, or 	
	 *		<br>there is a connected phone before ACC off and then ACC on </blockquote>
	 *
	 * @param enable true to enable or false to disable.
	 */
@Override public void setBtAutoConnectMode(boolean enable) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enable)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setBtAutoConnectMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Check if auto-connect is currently enabled.
	 *
	 * @return true if auto-connect is enabled.
	 */
@Override public boolean isBtAutoConnectEnable() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isBtAutoConnectEnable, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to connect HSP, HFP, A2DP, and AVRCP to remote device.
	 * <br>If remote device supports both HSP and HFP, nFore service connects HFP instead of HSP.
	 * <br>This is an asynchronous call: it will return immediately with int returned value, 
	 * which denotes the profiles nFore service plans to connect to, and 
	 * clients should register and implement callback functions
	 * {@link UiCallbackHsp#onHspStateChanged onHspStateChanged}, 
	 * {@link UiCallbackHfp#onHfpStateChanged onHfpStateChanged}, 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged}, and
	 * {@link UiCallbackAvrcp#onAvrcpStateChanged onAvrcpStateChanged}  
	 * to be notified of subsequent profile state changes.
	 * 
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return int value to denote the profiles planned to connect. Possible values are:
	 *		<blockquote><b>ERROR</b>	(int) -1
	 *		<br><b>PROFILE_HSP</b>		(int) 1
	 *		<br><b>PROFILE_HFP</b>		(int) (1 << 1)
	 *		<br><b>PROFILE_A2DP</b>		(int) (1 << 2)</blockquote>	 
	 * For example, value 6 (0000 0110) means that HFP and A2DP would be connected.	 	 
	 */
@Override public int reqBtConnectHfpA2dp(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqBtConnectHfpA2dp, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to disconnect all connected profiles.
	 * <br>This is an asynchronous call: it will return immediately with int returned value, 
	 * which denotes the profiles nFore service plans to disconnect to, and 
	 * clients should register and implement callback functions
	 * {@link UiCallbackHsp#onHspStateChanged onHspStateChanged}, 
	 * {@link UiCallbackHfp#onHfpStateChanged onHfpStateChanged}, 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged}, and
	 * {@link UiCallbackAvrcp#onAvrcpStateChanged onAvrcpStateChanged}  
	 * to be notified of subsequent profile state changes.
	 * 
	 * <br>If there is no connection currently, this request would return ERROR.
	 *
	 * @return int value to denote the profiles planned to disconnect. Possible values are:
	 *		<p><blockquote><b>ERROR</b>		(int) -1
	 *		<br><b>PROFILE_HSP</b>			(int) 1
	 *		<br><b>PROFILE_HFP</b>			(int) (1 << 1)
	 *		<br><b>PROFILE_A2DP</b>			(int) (1 << 2)
	 * 		<br><b>PROFILE_SPP</b>			(int) (1 << 3)
	 * 		<br><b>PROFILE_PBAP</b>			(int) (1 << 4)
	 *		<br><b>PROFILE_AVRCP</b>		(int) (1 << 5)
	 *		<br><b>PROFILE_FTP</b>			(int) (1 << 6)
	 *		<br><b>PROFILE_MAP</b>			(int) (1 << 7)
	 *		<br><b>PROFILE_AVRCP_13</b>		(int) (1 << 8)
	 *		<br><b>PROFILE_AVRCP_14</b>		(int) (1 << 9)
	 *		<br><b>PROFILE_PANU</b>			(int) (1 << 10)	
	 *		<br><b>PROFILE_NAP</b>			(int) (1 << 11)
	 *		<br><b>PROFILE_DUN</b>			(int) (1 << 12)</blockquote>	  
	 * For example, value 6 (0000 0110) means that HFP and A2DP would be disconnected.	 	 
	 */
@Override public int reqBtDisconnectAll() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqBtDisconnectAll, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the supported profiles of remote device.
	 * The requested address must be the paired device.
	 *
	 * This command will return with an integer value immediately, which represents the supported profiles.
	 * If 0x00 is returned, that means UUID fetched from system framework is null and nFore service will request
	 * SDP query to this device automatically. Clients should register and implement callback functions
	 * {@link IServiceCallback#onDeviceUuidsGot onDeviceUuidsGot} 
	 * to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address of paired device.
	 * @return the supported profiles of paired device in int type. Possible values are:
	 *		<p><blockquote><b>ERROR</b>		(int) -1
	 *		<br><b>PROFILE_HSP</b>			(int) 1
	 *		<br><b>PROFILE_HFP</b>			(int) (1 << 1)
	 *		<br><b>PROFILE_A2DP</b>			(int) (1 << 2)
	 * 		<br><b>PROFILE_SPP</b>			(int) (1 << 3)
	 * 		<br><b>PROFILE_PBAP</b>			(int) (1 << 4)
	 *		<br><b>PROFILE_AVRCP</b>		(int) (1 << 5)
	 *		<br><b>PROFILE_FTP</b>			(int) (1 << 6)
	 *		<br><b>PROFILE_MAP</b>			(int) (1 << 7)
	 *		<br><b>PROFILE_AVRCP_13</b>		(int) (1 << 8)
	 *		<br><b>PROFILE_AVRCP_14</b>		(int) (1 << 9)
	 *		<br><b>PROFILE_PANU</b>			(int) (1 << 10)
	 *		<br><b>PROFILE_NAP</b>			(int) (1 << 11)
	 *		<br><b>PROFILE_DUN</b>			(int) (1 << 12)
	 *		<br><b>PROFILE_IAP</b>			(int) (1 << 13)</blockquote>
	 * For example, value 7 (0000 0111) means it supports HSP, HFP and A2DP.
	 */
@Override public int getBtRemoteUuids(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_getBtRemoteUuids, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Switch Bluetooth mode to other role.
	 *
	 * @param mode the mode of Bluetooth role in integer type
	 * 		<p><blockquote><b>MODE_CAR</b>		(int) 1
	 *		<br><b>MODE_TABLET</b>				(int) 2
	 */
@Override public boolean switchBtRoleMode(int mode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(mode);
mRemote.transact(Stub.TRANSACTION_switchBtRoleMode, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Get Bluetooth role mode in integer.
	 *
	 * @return The mode of Bluetooth role in integer type
	 * 		<p><blockquote><b>MODE_CAR</b>		(int) 1
	 *		<br><b>MODE_TABLET</b>				(int) 2
	 */
@Override public int getBtRoleMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getBtRoleMode, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// HFP
/** 
	 * Register callback functions for HFP.
	 * <br>Call this function to register callback functions for HFP.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean registerHfpCallback(com.nforetek.bt.aidl.UiCallbackHfp cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerHfpCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Remove callback functions from HFP.
     * <br>Call this function to remove previously registered callback interface for HFP.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean unregisterHfpCallback(com.nforetek.bt.aidl.UiCallbackHfp cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterHfpCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get current connection state of the remote device.
	 * 
	 * @return current state of HFP profile service.
	 */
@Override public int getHfpConnectionState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHfpConnectionState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if local device is HFP connected with remote device.
	 *
	 * @return true to indicate HFP is connected, or false disconnected.
	 */
@Override public boolean isHfpConnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isHfpConnected, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the Bluetooth hardware address of HFP connected remote device.
	 *
	 * @return Bluetooth hardware address as string if there is a connected HFP device, or 
	 * <code>DEFAULT_ADDRESS</code> 00:00:00:00:00:00.
	 */
@Override public java.lang.String getHfpConnectedAddress() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHfpConnectedAddress, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the current audio state of HFP connected remote device.
	 * 
	 * @return current HFP audio state.
	 */
@Override public int getHfpAudioConnectionState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHfpAudioConnectionState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to connect HFP to the remote device.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackHfp#onHfpStateChanged onHfpStateChanged} to be notified of subsequent profile state changes.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqHfpConnect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqHfpConnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to disconnect HFP to the remote device.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackHfp#onHfpStateChanged onHfpStateChanged} to be notified of subsequent profile state changes.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqHfpDisconnect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqHfpDisconnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the signal strength of HFP connected remote device.
	 *	 	 
	 * @return the current signal strength of remote device.	 
	 */
@Override public int getHfpRemoteSignalStrength() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHfpRemoteSignalStrength, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the active phone number information of HFP connected remote device.
	 *	 	 
	 * @return the phone number information list of remote device.	 
	 */
@Override public java.util.List<com.nforetek.bt.aidl.NfHfpClientCall> getHfpCallList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.nforetek.bt.aidl.NfHfpClientCall> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHfpCallList, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.nforetek.bt.aidl.NfHfpClientCall.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if the HFP connected remote device is on roaming.
	 *	 	 
	 * @return true to indicate the remote device is current on roaming.	 
	 */
@Override public boolean isHfpRemoteOnRoaming() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isHfpRemoteOnRoaming, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the battery indicator of HFP connected remote device.
	 *
	 * @return the current battery indicator of remote device.
	 */
@Override public int getHfpRemoteBatteryIndicator() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHfpRemoteBatteryIndicator, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if the HFP connected remote device has telecom service.
	 *	 	 
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate remote device has telecom service.
	 */
@Override public boolean isHfpRemoteTelecomServiceOn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isHfpRemoteTelecomServiceOn, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if the voice dial of HFP connected remote device is activated.
	 *
	 * @param address valid Bluetooth MAC address of connected device.	 
	 * @return true to indicate voice dial is activated for remote device.
	 */
@Override public boolean isHfpRemoteVoiceDialOn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isHfpRemoteVoiceDialOn, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request HFP connected remote device to dial a call with given phone number.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 *
	 * @param number the outgoing call phone number.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqHfpDialCall(java.lang.String number) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(number);
mRemote.transact(Stub.TRANSACTION_reqHfpDialCall, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request HFP connected remote device to re-dial the last outgoing call.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqHfpReDial() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqHfpReDial, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request HFP connected remote device to do memory dialing.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 *
 	 * @param index the memory index on mobile phone. The phone number with the memory index will be dialed out, for example: 1-9
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqHfpMemoryDial(java.lang.String index) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(index);
mRemote.transact(Stub.TRANSACTION_reqHfpMemoryDial, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request HFP connected remote device to answer the incoming call.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true if the command is sent successfully
	 */
@Override public boolean reqHfpAnswerCall(int flag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flag);
mRemote.transact(Stub.TRANSACTION_reqHfpAnswerCall, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request HFP connected remote device to reject the incoming call.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true if the command is sent successfully
	 */
@Override public boolean reqHfpRejectIncomingCall() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqHfpRejectIncomingCall, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request HFP connected remote device to terminate the ongoing call.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link INfCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true if the command is sent successfully
	 */
@Override public boolean reqHfpTerminateCurrentCall() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqHfpTerminateCurrentCall, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request HFP connected remote device to send the DTMF.
	 * <p>Due to the compatibility, please request this API with single DTMF number each time.
	 * <p>Avoid requesting with serial DTMF numbers. 
	 *
 	 * @param number DTMF number.
 	 * @return true if the command is sent successfully
	 */
@Override public boolean reqHfpSendDtmf(java.lang.String number) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(number);
mRemote.transact(Stub.TRANSACTION_reqHfpSendDtmf, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request HFP connected remote device to transfer the audio to Carkit.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged} to be notified of subsequent state changes.
	 *
	 * @return true if the command is sent successfully	 
	 */
@Override public boolean reqHfpAudioTransferToCarkit() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqHfpAudioTransferToCarkit, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request HFP connected remote device to transfer the audio to Phone.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged} to be notified of subsequent state changes.
	 *
	 * @return true if the command is sent successfully	 
	 */
@Override public boolean reqHfpAudioTransferToPhone() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqHfpAudioTransferToPhone, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the network operator of HFP connected remote device.
	 *	 	 
	 * @return network operator
	 */
@Override public java.lang.String getHfpRemoteNetworkOperator() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHfpRemoteNetworkOperator, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the subscriber number of HFP connected remote device.
	 *	 	 
	 * @return subscriber number
	 */
@Override public java.lang.String getHfpRemoteSubscriberNumber() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHfpRemoteSubscriberNumber, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request HFP connected remote device to do the voice dialing.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 * 
 	 * @param enable true to start the voice dialing.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqHfpVoiceDial(boolean enable) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enable)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_reqHfpVoiceDial, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Stop sending HFP stream data to audio track.
	 */
@Override public void pauseHfpRender() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_pauseHfpRender, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Start sending HFP stream data to audio track.
	 */
@Override public void startHfpRender() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_startHfpRender, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Check if mic is mute.
	 */
@Override public boolean isHfpMicMute() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isHfpMicMute, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request HFP Mute Mic during call
	 * @param mute true to mute the microphone
	 */
@Override public void muteHfpMic(boolean mute) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((mute)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_muteHfpMic, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean isHfpInBandRingtoneSupport() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isHfpInBandRingtoneSupport, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// PBAP
/** 
	 * Register callback functions for PBAP.
	 * <br>Call this function to register callback functions for PBAP.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean registerPbapCallback(com.nforetek.bt.aidl.UiCallbackPbap cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerPbapCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Remove callback functions from PBAP.
     * <br>Call this function to remove previously registered callback interface for PBAP.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean unregisterPbapCallback(com.nforetek.bt.aidl.UiCallbackPbap cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterPbapCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get current connection state of the remote device.
	 *
	 * @return current state of PBAP profile service.
	 */
@Override public int getPbapConnectionState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPbapConnectionState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if local device is downloading phonebook from remote device.
	 *
	 * @return true to indicate PBAP is downloading, or false disconnected.
	 */
@Override public boolean isPbapDownloading() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isPbapDownloading, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the Bluetooth hardware address of PBAP downloading remote device.
	 *
	 * @return Bluetooth hardware address as string if there is a downloading PBAP device, 
	 * or otherwise <code>DEFAULT_ADDRESS</code> 00:00:00:00:00:00.
	 */
@Override public java.lang.String getPbapDownloadingAddress() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPbapDownloadingAddress, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to download phonebook with vCard from remote device and by pass callback to user.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackPbap#retPbapDownloadedContact retPbapDownloadedContact} 
	 * and {@link INfCallbackPbap#retPbapDownloadedCallLog retPbapDownloadedCallLog}
	 * and {@link INfCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6
	 *		<br><b>PBAP_STORAGE_SPEEDDIAL</b>			(int) 7
	 *		<br><b>PBAP_STORAGE_FAVORITE</b>			(int) 8</blockquote>
	 * @param property download property mask. Possible storage type are:
	 *		<blockquote><b>PBAP_PROPERTY_MASK_VERSION</b>	(int) (1&lt;&lt;0)
	 *		<br><b>PBAP_PROPERTY_MASK_FN</b>		(int) (1&lt;&lt;1)
	 *		<br><b>PBAP_PROPERTY_MASK_N</b>			(int) (1&lt;&lt;2)
	 *		<br><b>PBAP_PROPERTY_MASK_PHOTO</b>		(int) (1&lt;&lt;3)
	 *		<br><b>PBAP_PROPERTY_MASK_BDAY</b>		(int) (1&lt;&lt;4)
	 *		<br><b>PBAP_PROPERTY_MASK_ADR</b>		(int) (1&lt;&lt;5)
	 *		<br><b>PBAP_PROPERTY_MASK_LABEL</b>		(int) (1&lt;&lt;6)
	 *		<br><b>PBAP_PROPERTY_MASK_TEL</b>		(int) (1&lt;&lt;7)
	 *		<br><b>PBAP_PROPERTY_MASK_EMAIL</b>		(int) (1&lt;&lt;8)
	 *		<br><b>PBAP_PROPERTY_MASK_MAILER</b>	(int) (1&lt;&lt;9)
	 *		<br><b>PBAP_PROPERTY_MASK_TZ</b>		(int) (1&lt;&lt;10)
	 *		<br><b>PBAP_PROPERTY_MASK_GEO</b>		(int) (1&lt;&lt;11)
	 *		<br><b>PBAP_PROPERTY_MASK_TITLE</b>		(int) (1&lt;&lt;12)
	 *		<br><b>PBAP_PROPERTY_MASK_ROLE</b>		(int) (1&lt;&lt;13)
	 *		<br><b>PBAP_PROPERTY_MASK_LOGO</b>		(int) (1&lt;&lt;14)
	 *		<br><b>PBAP_PROPERTY_MASK_AGENT</b>		(int) (1&lt;&lt;15)
	 *		<br><b>PBAP_PROPERTY_MASK_ORG</b>		(int) (1&lt;&lt;16)
	 *		<br><b>PBAP_PROPERTY_MASK_NOTE</b>		(int) (1&lt;&lt;17)
	 *		<br><b>PBAP_PROPERTY_MASK_REV</b>		(int) (1&lt;&lt;18)
	 *		<br><b>PBAP_PROPERTY_MASK_SOUND</b>		(int) (1&lt;&lt;19)
	 *		<br><b>PBAP_PROPERTY_MASK_URL</b>		(int) (1&lt;&lt;20)
	 *		<br><b>PBAP_PROPERTY_MASK_UID</b>		(int) (1&lt;&lt;21)
	 *		<br><b>PBAP_PROPERTY_MASK_KEY</b>		(int) (1&lt;&lt;22)
	 *		<br><b>PBAP_PROPERTY_MASK_NICKNAME</b>	(int) (1&lt;&lt;23)
	 *		<br><b>PBAP_PROPERTY_MASK_CATEGORIES</b>(int) (1&lt;&lt;24)
	 *		<br><b>PBAP_PROPERTY_MASK_PROID</b>		(int) (1&lt;&lt;25)
	 *		<br><b>PBAP_PROPERTY_MASK_CLASS</b>		(int) (1&lt;&lt;26)
	 *		<br><b>PBAP_PROPERTY_MASK_SORT_STRING</b>(int) (1&lt;&lt;27)
	 *		<br><b>PBAP_PROPERTY_MASK_TIME_STAMP</b>(int) (1&lt;&lt;28)</blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqPbapDownload(java.lang.String address, int storage, int property) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(storage);
_data.writeInt(property);
mRemote.transact(Stub.TRANSACTION_reqPbapDownload, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to download phonebook with vCard from remote device and by pass callback to user.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackPbap#retPbapDownloadedContact retPbapDownloadedContact} 
	 * and {@link INfCallbackPbap#retPbapDownloadedCallLog retPbapDownloadedCallLog}
	 * and {@link INfCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6
	 *		<br><b>PBAP_STORAGE_SPEEDDIAL</b>			(int) 7
	 *		<br><b>PBAP_STORAGE_FAVORITE</b>			(int) 8</blockquote>
	 * @param property download property mask. Possible storage type are:
	 *		<blockquote><b>PBAP_PROPERTY_MASK_VERSION</b>	(int) (1&lt;&lt;0)
	 *		<br><b>PBAP_PROPERTY_MASK_FN</b>		(int) (1&lt;&lt;1)
	 *		<br><b>PBAP_PROPERTY_MASK_N</b>			(int) (1&lt;&lt;2)
	 *		<br><b>PBAP_PROPERTY_MASK_PHOTO</b>		(int) (1&lt;&lt;3)
	 *		<br><b>PBAP_PROPERTY_MASK_BDAY</b>		(int) (1&lt;&lt;4)
	 *		<br><b>PBAP_PROPERTY_MASK_ADR</b>		(int) (1&lt;&lt;5)
	 *		<br><b>PBAP_PROPERTY_MASK_LABEL</b>		(int) (1&lt;&lt;6)
	 *		<br><b>PBAP_PROPERTY_MASK_TEL</b>		(int) (1&lt;&lt;7)
	 *		<br><b>PBAP_PROPERTY_MASK_EMAIL</b>		(int) (1&lt;&lt;8)
	 *		<br><b>PBAP_PROPERTY_MASK_MAILER</b>	(int) (1&lt;&lt;9)
	 *		<br><b>PBAP_PROPERTY_MASK_TZ</b>		(int) (1&lt;&lt;10)
	 *		<br><b>PBAP_PROPERTY_MASK_GEO</b>		(int) (1&lt;&lt;11)
	 *		<br><b>PBAP_PROPERTY_MASK_TITLE</b>		(int) (1&lt;&lt;12)
	 *		<br><b>PBAP_PROPERTY_MASK_ROLE</b>		(int) (1&lt;&lt;13)
	 *		<br><b>PBAP_PROPERTY_MASK_LOGO</b>		(int) (1&lt;&lt;14)
	 *		<br><b>PBAP_PROPERTY_MASK_AGENT</b>		(int) (1&lt;&lt;15)
	 *		<br><b>PBAP_PROPERTY_MASK_ORG</b>		(int) (1&lt;&lt;16)
	 *		<br><b>PBAP_PROPERTY_MASK_NOTE</b>		(int) (1&lt;&lt;17)
	 *		<br><b>PBAP_PROPERTY_MASK_REV</b>		(int) (1&lt;&lt;18)
	 *		<br><b>PBAP_PROPERTY_MASK_SOUND</b>		(int) (1&lt;&lt;19)
	 *		<br><b>PBAP_PROPERTY_MASK_URL</b>		(int) (1&lt;&lt;20)
	 *		<br><b>PBAP_PROPERTY_MASK_UID</b>		(int) (1&lt;&lt;21)
	 *		<br><b>PBAP_PROPERTY_MASK_KEY</b>		(int) (1&lt;&lt;22)
	 *		<br><b>PBAP_PROPERTY_MASK_NICKNAME</b>	(int) (1&lt;&lt;23)
	 *		<br><b>PBAP_PROPERTY_MASK_CATEGORIES</b>(int) (1&lt;&lt;24)
	 *		<br><b>PBAP_PROPERTY_MASK_PROID</b>		(int) (1&lt;&lt;25)
	 *		<br><b>PBAP_PROPERTY_MASK_CLASS</b>		(int) (1&lt;&lt;26)
	 *		<br><b>PBAP_PROPERTY_MASK_SORT_STRING</b>(int) (1&lt;&lt;27)
	 *		<br><b>PBAP_PROPERTY_MASK_TIME_STAMP</b>(int) (1&lt;&lt;28)</blockquote>
	 * @param startPos download start position.
	 * @param offset download offset.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqPbapDownloadRange(java.lang.String address, int storage, int property, int startPos, int offset) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(storage);
_data.writeInt(property);
_data.writeInt(startPos);
_data.writeInt(offset);
mRemote.transact(Stub.TRANSACTION_reqPbapDownloadRange, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to download phonebook with vCard from remote device and save to local database.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6
	 *		<br><b>PBAP_STORAGE_SPEEDDIAL</b>			(int) 7
	 *		<br><b>PBAP_STORAGE_FAVORITE</b>			(int) 8</blockquote>	
	 * @param property download property mask. Possible storage type are:
	 *		<blockquote><b>PBAP_PROPERTY_MASK_VERSION</b>	(int) (1&lt;&lt;0)
	 *		<br><b>PBAP_PROPERTY_MASK_FN</b>		(int) (1&lt;&lt;1)
	 *		<br><b>PBAP_PROPERTY_MASK_N</b>			(int) (1&lt;&lt;2)
	 *		<br><b>PBAP_PROPERTY_MASK_PHOTO</b>		(int) (1&lt;&lt;3)
	 *		<br><b>PBAP_PROPERTY_MASK_BDAY</b>		(int) (1&lt;&lt;4)
	 *		<br><b>PBAP_PROPERTY_MASK_ADR</b>		(int) (1&lt;&lt;5)
	 *		<br><b>PBAP_PROPERTY_MASK_LABEL</b>		(int) (1&lt;&lt;6)
	 *		<br><b>PBAP_PROPERTY_MASK_TEL</b>		(int) (1&lt;&lt;7)
	 *		<br><b>PBAP_PROPERTY_MASK_EMAIL</b>		(int) (1&lt;&lt;8)
	 *		<br><b>PBAP_PROPERTY_MASK_MAILER</b>	(int) (1&lt;&lt;9)
	 *		<br><b>PBAP_PROPERTY_MASK_TZ</b>		(int) (1&lt;&lt;10)
	 *		<br><b>PBAP_PROPERTY_MASK_GEO</b>		(int) (1&lt;&lt;11)
	 *		<br><b>PBAP_PROPERTY_MASK_TITLE</b>		(int) (1&lt;&lt;12)
	 *		<br><b>PBAP_PROPERTY_MASK_ROLE</b>		(int) (1&lt;&lt;13)
	 *		<br><b>PBAP_PROPERTY_MASK_LOGO</b>		(int) (1&lt;&lt;14)
	 *		<br><b>PBAP_PROPERTY_MASK_AGENT</b>		(int) (1&lt;&lt;15)
	 *		<br><b>PBAP_PROPERTY_MASK_ORG</b>		(int) (1&lt;&lt;16)
	 *		<br><b>PBAP_PROPERTY_MASK_NOTE</b>		(int) (1&lt;&lt;17)
	 *		<br><b>PBAP_PROPERTY_MASK_REV</b>		(int) (1&lt;&lt;18)
	 *		<br><b>PBAP_PROPERTY_MASK_SOUND</b>		(int) (1&lt;&lt;19)
	 *		<br><b>PBAP_PROPERTY_MASK_URL</b>		(int) (1&lt;&lt;20)
	 *		<br><b>PBAP_PROPERTY_MASK_UID</b>		(int) (1&lt;&lt;21)
	 *		<br><b>PBAP_PROPERTY_MASK_KEY</b>		(int) (1&lt;&lt;22)
	 *		<br><b>PBAP_PROPERTY_MASK_NICKNAME</b>	(int) (1&lt;&lt;23)
	 *		<br><b>PBAP_PROPERTY_MASK_CATEGORIES</b>(int) (1&lt;&lt;24)
	 *		<br><b>PBAP_PROPERTY_MASK_PROID</b>		(int) (1&lt;&lt;25)
	 *		<br><b>PBAP_PROPERTY_MASK_CLASS</b>		(int) (1&lt;&lt;26)
	 *		<br><b>PBAP_PROPERTY_MASK_SORT_STRING</b>(int) (1&lt;&lt;27)
	 *		<br><b>PBAP_PROPERTY_MASK_TIME_STAMP</b>(int) (1&lt;&lt;28)</blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqPbapDownloadToDatabase(java.lang.String address, int storage, int property) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(storage);
_data.writeInt(property);
mRemote.transact(Stub.TRANSACTION_reqPbapDownloadToDatabase, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to download phonebook with vCard from remote device and save to local Contacts Provider.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6
	 *		<br><b>PBAP_STORAGE_SPEEDDIAL</b>			(int) 7
	 *		<br><b>PBAP_STORAGE_FAVORITE</b>			(int) 8</blockquote>
	 * @param property download property mask. Possible storage type are:
	 *		<blockquote><b>PBAP_PROPERTY_MASK_VERSION</b>	(int) (1&lt;&lt;0)
	 *		<br><b>PBAP_PROPERTY_MASK_FN</b>		(int) (1&lt;&lt;1)
	 *		<br><b>PBAP_PROPERTY_MASK_N</b>			(int) (1&lt;&lt;2)
	 *		<br><b>PBAP_PROPERTY_MASK_PHOTO</b>		(int) (1&lt;&lt;3)
	 *		<br><b>PBAP_PROPERTY_MASK_BDAY</b>		(int) (1&lt;&lt;4)
	 *		<br><b>PBAP_PROPERTY_MASK_ADR</b>		(int) (1&lt;&lt;5)
	 *		<br><b>PBAP_PROPERTY_MASK_LABEL</b>		(int) (1&lt;&lt;6)
	 *		<br><b>PBAP_PROPERTY_MASK_TEL</b>		(int) (1&lt;&lt;7)
	 *		<br><b>PBAP_PROPERTY_MASK_EMAIL</b>		(int) (1&lt;&lt;8)
	 *		<br><b>PBAP_PROPERTY_MASK_MAILER</b>	(int) (1&lt;&lt;9)
	 *		<br><b>PBAP_PROPERTY_MASK_TZ</b>		(int) (1&lt;&lt;10)
	 *		<br><b>PBAP_PROPERTY_MASK_GEO</b>		(int) (1&lt;&lt;11)
	 *		<br><b>PBAP_PROPERTY_MASK_TITLE</b>		(int) (1&lt;&lt;12)
	 *		<br><b>PBAP_PROPERTY_MASK_ROLE</b>		(int) (1&lt;&lt;13)
	 *		<br><b>PBAP_PROPERTY_MASK_LOGO</b>		(int) (1&lt;&lt;14)
	 *		<br><b>PBAP_PROPERTY_MASK_AGENT</b>		(int) (1&lt;&lt;15)
	 *		<br><b>PBAP_PROPERTY_MASK_ORG</b>		(int) (1&lt;&lt;16)
	 *		<br><b>PBAP_PROPERTY_MASK_NOTE</b>		(int) (1&lt;&lt;17)
	 *		<br><b>PBAP_PROPERTY_MASK_REV</b>		(int) (1&lt;&lt;18)
	 *		<br><b>PBAP_PROPERTY_MASK_SOUND</b>		(int) (1&lt;&lt;19)
	 *		<br><b>PBAP_PROPERTY_MASK_URL</b>		(int) (1&lt;&lt;20)
	 *		<br><b>PBAP_PROPERTY_MASK_UID</b>		(int) (1&lt;&lt;21)
	 *		<br><b>PBAP_PROPERTY_MASK_KEY</b>		(int) (1&lt;&lt;22)
	 *		<br><b>PBAP_PROPERTY_MASK_NICKNAME</b>	(int) (1&lt;&lt;23)
	 *		<br><b>PBAP_PROPERTY_MASK_CATEGORIES</b>(int) (1&lt;&lt;24)
	 *		<br><b>PBAP_PROPERTY_MASK_PROID</b>		(int) (1&lt;&lt;25)
	 *		<br><b>PBAP_PROPERTY_MASK_CLASS</b>		(int) (1&lt;&lt;26)
	 *		<br><b>PBAP_PROPERTY_MASK_SORT_STRING</b>(int) (1&lt;&lt;27)
	 *		<br><b>PBAP_PROPERTY_MASK_TIME_STAMP</b>(int) (1&lt;&lt;28)</blockquote>
	 * @param startPos download start position.
	 * @param offset download offset.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqPbapDownloadRangeToDatabase(java.lang.String address, int storage, int property, int startPos, int offset) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(storage);
_data.writeInt(property);
_data.writeInt(startPos);
_data.writeInt(offset);
mRemote.transact(Stub.TRANSACTION_reqPbapDownloadRangeToDatabase, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to download phonebook with vCard from remote device and save to local Contacts Provider.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6
	 *		<br><b>PBAP_STORAGE_SPEEDDIAL</b>			(int) 7
	 *		<br><b>PBAP_STORAGE_FAVORITE</b>			(int) 8</blockquote>
	 * @param property download property mask. Possible storage type are:
	 *		<blockquote><b>PBAP_PROPERTY_MASK_VERSION</b>	(int) (1&lt;&lt;0)
	 *		<br><b>PBAP_PROPERTY_MASK_FN</b>		(int) (1&lt;&lt;1)
	 *		<br><b>PBAP_PROPERTY_MASK_N</b>			(int) (1&lt;&lt;2)
	 *		<br><b>PBAP_PROPERTY_MASK_PHOTO</b>		(int) (1&lt;&lt;3)
	 *		<br><b>PBAP_PROPERTY_MASK_BDAY</b>		(int) (1&lt;&lt;4)
	 *		<br><b>PBAP_PROPERTY_MASK_ADR</b>		(int) (1&lt;&lt;5)
	 *		<br><b>PBAP_PROPERTY_MASK_LABEL</b>		(int) (1&lt;&lt;6)
	 *		<br><b>PBAP_PROPERTY_MASK_TEL</b>		(int) (1&lt;&lt;7)
	 *		<br><b>PBAP_PROPERTY_MASK_EMAIL</b>		(int) (1&lt;&lt;8)
	 *		<br><b>PBAP_PROPERTY_MASK_MAILER</b>	(int) (1&lt;&lt;9)
	 *		<br><b>PBAP_PROPERTY_MASK_TZ</b>		(int) (1&lt;&lt;10)
	 *		<br><b>PBAP_PROPERTY_MASK_GEO</b>		(int) (1&lt;&lt;11)
	 *		<br><b>PBAP_PROPERTY_MASK_TITLE</b>		(int) (1&lt;&lt;12)
	 *		<br><b>PBAP_PROPERTY_MASK_ROLE</b>		(int) (1&lt;&lt;13)
	 *		<br><b>PBAP_PROPERTY_MASK_LOGO</b>		(int) (1&lt;&lt;14)
	 *		<br><b>PBAP_PROPERTY_MASK_AGENT</b>		(int) (1&lt;&lt;15)
	 *		<br><b>PBAP_PROPERTY_MASK_ORG</b>		(int) (1&lt;&lt;16)
	 *		<br><b>PBAP_PROPERTY_MASK_NOTE</b>		(int) (1&lt;&lt;17)
	 *		<br><b>PBAP_PROPERTY_MASK_REV</b>		(int) (1&lt;&lt;18)
	 *		<br><b>PBAP_PROPERTY_MASK_SOUND</b>		(int) (1&lt;&lt;19)
	 *		<br><b>PBAP_PROPERTY_MASK_URL</b>		(int) (1&lt;&lt;20)
	 *		<br><b>PBAP_PROPERTY_MASK_UID</b>		(int) (1&lt;&lt;21)
	 *		<br><b>PBAP_PROPERTY_MASK_KEY</b>		(int) (1&lt;&lt;22)
	 *		<br><b>PBAP_PROPERTY_MASK_NICKNAME</b>	(int) (1&lt;&lt;23)
	 *		<br><b>PBAP_PROPERTY_MASK_CATEGORIES</b>(int) (1&lt;&lt;24)
	 *		<br><b>PBAP_PROPERTY_MASK_PROID</b>		(int) (1&lt;&lt;25)
	 *		<br><b>PBAP_PROPERTY_MASK_CLASS</b>		(int) (1&lt;&lt;26)
	 *		<br><b>PBAP_PROPERTY_MASK_SORT_STRING</b>(int) (1&lt;&lt;27)
	 *		<br><b>PBAP_PROPERTY_MASK_TIME_STAMP</b>(int) (1&lt;&lt;28)</blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqPbapDownloadToContactsProvider(java.lang.String address, int storage, int property) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(storage);
_data.writeInt(property);
mRemote.transact(Stub.TRANSACTION_reqPbapDownloadToContactsProvider, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to download phonebook with vCard from remote device and save to local Contacts Provider.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6
	 *		<br><b>PBAP_STORAGE_SPEEDDIAL</b>			(int) 7
	 *		<br><b>PBAP_STORAGE_FAVORITE</b>			(int) 8</blockquote>
	 * @param property download property mask. Possible storage type are:
	 *		<blockquote><b>PBAP_PROPERTY_MASK_VERSION</b>	(int) (1&lt;&lt;0)
	 *		<br><b>PBAP_PROPERTY_MASK_FN</b>		(int) (1&lt;&lt;1)
	 *		<br><b>PBAP_PROPERTY_MASK_N</b>			(int) (1&lt;&lt;2)
	 *		<br><b>PBAP_PROPERTY_MASK_PHOTO</b>		(int) (1&lt;&lt;3)
	 *		<br><b>PBAP_PROPERTY_MASK_BDAY</b>		(int) (1&lt;&lt;4)
	 *		<br><b>PBAP_PROPERTY_MASK_ADR</b>		(int) (1&lt;&lt;5)
	 *		<br><b>PBAP_PROPERTY_MASK_LABEL</b>		(int) (1&lt;&lt;6)
	 *		<br><b>PBAP_PROPERTY_MASK_TEL</b>		(int) (1&lt;&lt;7)
	 *		<br><b>PBAP_PROPERTY_MASK_EMAIL</b>		(int) (1&lt;&lt;8)
	 *		<br><b>PBAP_PROPERTY_MASK_MAILER</b>	(int) (1&lt;&lt;9)
	 *		<br><b>PBAP_PROPERTY_MASK_TZ</b>		(int) (1&lt;&lt;10)
	 *		<br><b>PBAP_PROPERTY_MASK_GEO</b>		(int) (1&lt;&lt;11)
	 *		<br><b>PBAP_PROPERTY_MASK_TITLE</b>		(int) (1&lt;&lt;12)
	 *		<br><b>PBAP_PROPERTY_MASK_ROLE</b>		(int) (1&lt;&lt;13)
	 *		<br><b>PBAP_PROPERTY_MASK_LOGO</b>		(int) (1&lt;&lt;14)
	 *		<br><b>PBAP_PROPERTY_MASK_AGENT</b>		(int) (1&lt;&lt;15)
	 *		<br><b>PBAP_PROPERTY_MASK_ORG</b>		(int) (1&lt;&lt;16)
	 *		<br><b>PBAP_PROPERTY_MASK_NOTE</b>		(int) (1&lt;&lt;17)
	 *		<br><b>PBAP_PROPERTY_MASK_REV</b>		(int) (1&lt;&lt;18)
	 *		<br><b>PBAP_PROPERTY_MASK_SOUND</b>		(int) (1&lt;&lt;19)
	 *		<br><b>PBAP_PROPERTY_MASK_URL</b>		(int) (1&lt;&lt;20)
	 *		<br><b>PBAP_PROPERTY_MASK_UID</b>		(int) (1&lt;&lt;21)
	 *		<br><b>PBAP_PROPERTY_MASK_KEY</b>		(int) (1&lt;&lt;22)
	 *		<br><b>PBAP_PROPERTY_MASK_NICKNAME</b>	(int) (1&lt;&lt;23)
	 *		<br><b>PBAP_PROPERTY_MASK_CATEGORIES</b>(int) (1&lt;&lt;24)
	 *		<br><b>PBAP_PROPERTY_MASK_PROID</b>		(int) (1&lt;&lt;25)
	 *		<br><b>PBAP_PROPERTY_MASK_CLASS</b>		(int) (1&lt;&lt;26)
	 *		<br><b>PBAP_PROPERTY_MASK_SORT_STRING</b>(int) (1&lt;&lt;27)
	 *		<br><b>PBAP_PROPERTY_MASK_TIME_STAMP</b>(int) (1&lt;&lt;28)</blockquote>
	 * @param startPos download start position.
	 * @param offset download offset.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqPbapDownloadRangeToContactsProvider(java.lang.String address, int storage, int property, int startPos, int offset) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(storage);
_data.writeInt(property);
_data.writeInt(startPos);
_data.writeInt(offset);
mRemote.transact(Stub.TRANSACTION_reqPbapDownloadRangeToContactsProvider, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to query the corresponding name by a given phone number from database.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackPbap#retPbapDatabaseQueryNameByNumber retPbapDatabaseQueryNameByNumber} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
     * @param target the phone number given to database query.
     */
@Override public void reqPbapDatabaseQueryNameByNumber(java.lang.String address, java.lang.String target) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(target);
mRemote.transact(Stub.TRANSACTION_reqPbapDatabaseQueryNameByNumber, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Request to querythe corresponding name by a given partial phone number from database.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackPbap#retPbapDatabaseQueryNameByPartialNumber retPbapDatabaseQueryNameByPartialNumber} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
     * @param target the phone number given to database query like number.
     * @param findPosition decide which target position you want to find. Possible value are:
     *		<br>For example: target is 123.
     *		<blockquote><b>SQL_QUERY_FIND_CONTAIN</b>		(int) 0 ex. XXX<b>123</b>XXX
	 *		<br><b>SQL_QUERY_FIND_HEAD</b>					(int) 1 ex. <b>123</b>XXXXXX
	 *		<br><b>SQL_QUERY_FIND_TAIL</b>					(int) 2 ex. XXXXXX<b>123</b></blockquote>
     */
@Override public void reqPbapDatabaseQueryNameByPartialNumber(java.lang.String address, java.lang.String target, int findPosition) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(target);
_data.writeInt(findPosition);
mRemote.transact(Stub.TRANSACTION_reqPbapDatabaseQueryNameByPartialNumber, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Request to check if nFore's PBAP database is available for query.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackPbap#retPbapDatabaseAvailable retPbapDatabaseAvailable} to be notified when database is available.
	 *
	 * <p>When nFore's PBAP database is required to access, this command has to be issued in advanced and wait for 
	 * the callback {@link UiCallbackPbap#retPbapDatabaseAvailable retPbapDatabaseAvailable}. Or the database may be crashed!
	 * <br>After nFore's PBAP database is done accessing, the database resource needs to be released. And should <b>never</b> use commands
	 * {@link UiCommandPbap#reqPbapDownloadToDatabase reqPbapDownloadToDatabase}, 
	 * {@link UiCommandPbap#reqPbapDownloadToContactsProvider reqPbapDownloadToContactsProvider},
	 * {@link UiCommandPbap#reqPbapDatabaseQueryNameByNumber reqPbapDatabaseQueryNameByNumber} or 
	 * {@link UiCommandPbap#reqPbapDatabaseQueryNameByPartialNumber reqPbapDatabaseQueryNameByPartialNumber} 
	 * before the database resource is released. 
	 * 
	 * @param address valid Bluetooth MAC address.
	 */
@Override public void reqPbapDatabaseAvailable(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqPbapDatabaseAvailable, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Request to delete phonebook data of specific address from database.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackPbap#retPbapDeleteDatabaseByAddressCompleted retPbapDeleteDatabaseByAddressCompleted} to be notified when database has been deleted.
	 *
	 * @param address valid Bluetooth MAC address.
	 */
@Override public void reqPbapDeleteDatabaseByAddress(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqPbapDeleteDatabaseByAddress, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Request to clean whole PBAP database.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackPbap#retPbapCleanDatabaseCompleted retPbapCleanDatabaseCompleted} to be notified when database has been cleaned.
	 */
@Override public void reqPbapCleanDatabase() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqPbapCleanDatabase, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Request to interrupt the ongoing download from remote device.
	 *
	 * <br>Clients should register and implement callback function {@link UiCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.    
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true if really try to interrupt.
	 */
@Override public boolean reqPbapDownloadInterrupt(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqPbapDownloadInterrupt, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Set PBAP download notify frequency. Will set to default value when ServiceManager restart.
	 * Default value is 0 means don't callback download notify. For example, if frequency is set to 5, every 5 contacts onPbapDownloadNofity will be notified.
	 *
	 * <br>Clients should register and implement callback function {@link INfCallbackPbap#onPbapDownloadNotify onPbapDownloadNotify} to be notified of subsequent result.
	 * Callback will be invoked if below commands are issued     
	 * {@link INfCommandPbap#reqPbapDownload reqPbapDownload}, 
	 * {@link INfCommandPbap#reqPbapDownloadRange reqPbapDownloadRange},
	 * {@link INfCommandPbap#reqPbapDownloadToDatabase reqPbapDownloadToDatabase},
	 * {@link INfCommandPbap#reqPbapDownloadRangeToDatabase reqPbapDownloadRangeToDatabase},
	 * {@link INfCommandPbap#reqPbapDownloadToContactsProvider reqPbapDownloadToContactsProvider} or 
	 * {@link INfCommandPbap#reqPbapDownloadRangeToContactsProvider reqPbapDownloadRangeToContactsProvider} 
	 *
	 * @param frequency define the callback frequency.
     *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean setPbapDownloadNotify(int frequency) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(frequency);
mRemote.transact(Stub.TRANSACTION_setPbapDownloadNotify, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// SPP
/** 
	 * Register callback functions for SPP profile.
	 * Call this function to register callback functions for SPP profile.
	 * Allow nFore service to call back to its registered clients, which might often be UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean registerSppCallback(com.nforetek.bt.aidl.UiCallbackSpp cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerSppCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Remove callback functions for SPP profile.
     * Call this function to remove previously registered callback interface for SPP profile.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean unregisterSppCallback(com.nforetek.bt.aidl.UiCallbackSpp cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterSppCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to connect SPP to the remote device.
	 *
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link INfCallbackSpp#onSppStateChanged onSppStateChanged} to be notified of subsequent profile state changes.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqSppConnect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqSppConnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to disconnect the connected SPP connection to the remote device.
	 *
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link INfCallbackSpp#onSppStateChanged onSppStateChanged} to be notified of subsequent profile state changes.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqSppDisconnect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqSppDisconnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request for the hardware Bluetooth address of the remote SPP devices.
	 * For example, "00:11:22:AA:BB:CC".
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link INfCallbackSpp#retSppConnectedDeviceAddressList retSppConnectedDeviceAddressList} to be notified of subsequent result.
	 */
@Override public void reqSppConnectedDeviceAddressList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqSppConnectedDeviceAddressList, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Check if local device is SPP connected with the remote device. 	 
	 *
	 * @param address valid Bluetooth MAC address.	 
	 * @return true if device with given address is currently connected.
	 */
@Override public boolean isSppConnected(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_isSppConnected, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to send given data to the remote SPP device.
	 * 
	 * Data size should not be greater than 512 bytes each time. 
	 *
	 * @param address valid Bluetooth MAC address of connected device.
	 * @param sppData the data to be sent.
	 */
@Override public void reqSppSendData(java.lang.String address, byte[] sppData) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeByteArray(sppData);
mRemote.transact(Stub.TRANSACTION_reqSppSendData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Register callback functions for HID.
	 * <br>Call this function to register callback functions for HID.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean registerHidCallback(com.nforetek.bt.aidl.UiCallbackHid cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerHidCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Remove callback functions from HID.
     * <br>Call this function to remove previously registered callback interface for HID.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean unregisterHidCallback(com.nforetek.bt.aidl.UiCallbackHid cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterHidCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get current connection state of the remote device.
	 *
	 * @return current state of HID profile service.
	 */
@Override public int getHidConnectionState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHidConnectionState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Check if local device is HID connected with remote device.
	 *
	 * @return true to indicate HID is connected, or false disconnected.
	 */
@Override public boolean isHidConnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isHidConnected, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get the Bluetooth hardware address of HID connected remote device.
	 *
	 * @return Bluetooth hardware address as string if there is a connected HID device, or 
	 * <code>DEFAULT_ADDRESS</code> 00:00:00:00:00:00.
	 */
@Override public java.lang.String getHidConnectedAddress() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHidConnectedAddress, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to connect HID to the remote device.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackHid#onHidStateChanged onHidStateChanged} to be notified of subsequent profile state changes.
	 * 
	 * <p>There is no guarantee that Hid will be connected and the sequence of state changed callback of profiles! 
	 * <br>This depends on the behavior of connected device.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqHidConnect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqHidConnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to disconnect HID to the remote device.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackHid#onHidStateChanged onHidStateChanged} to be notified of subsequent profile state changes.
	 * 
	 * <p>There is no guarantee that HID will be disconnected and the sequence of state changed callback of profiles! 
	 * <br>This depends on the behavior of connected device.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqHidDisconnect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqHidDisconnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to send HID mouse command to the remote device.
	 * 
	 * It should be noticed that the function is available after HID connect success.
	 * The return value is an integer means this function has sent data to the remote device. 0 means fail.
	 * @param button : You should put the correct value to this parameter. For exmple : 0x01 means left button. 0x02 means right button.	
	 *				   Please refers to "USB HID Usage Tables, v1.12, page 67". 		   
	 * @param offset_x : You should put x-direction of mouse offset on this parameter. The range should be in (32768 ~ -32768).
	 *				   The parameter is the relative value of last position.
	 * @param offset_y : You should put y-direction of mouse offset on this parameter. The range should be in (32768 ~ -32768).
	 *				   The parameter is the relative value of last position.
	 * @param wheel : You should put wheel information of mouse offset on this parameter. The range should be in (127 ~ -127).
	 *				   The parameter is the relative value of last position.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqSendHidMouseCommand(int button, int offset_x, int offset_y, int wheel) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(button);
_data.writeInt(offset_x);
_data.writeInt(offset_y);
_data.writeInt(wheel);
mRemote.transact(Stub.TRANSACTION_reqSendHidMouseCommand, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to send virtual key event to the remote device.
	 * 
	 * It should be noticed that the function is available after HID connect success.
	 * The return value is an integer means this function has sent data to the remote device. 0 means fail.
	 * About the key_1 and key_2 value, please refers to "USB HID Usage Tables, v1.12, page 75-102".
	 * @param key_1 : You should put virtual key command on this parameter. For example, 0x223 means home key. 0x224 means back button.
	 * 					The range should be in (1 ~ 652).
	 * @param key_2 : You should put virtual key command on this parameter. For example, 0x223 means home key. 0x224 means back button.
	 * 					The range should be in (1 ~ 652).
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqSendHidVirtualKeyCommand(int key_1, int key_2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(key_1);
_data.writeInt(key_2);
mRemote.transact(Stub.TRANSACTION_reqSendHidVirtualKeyCommand, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// MAP
/** 
	 * Register callback functions for MAP.
	 * <br>Call this function to register callback functions for MAP.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean registerMapCallback(com.nforetek.bt.aidl.UiCallbackMap cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerMapCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Remove callback functions from MAP.
     * <br>Call this function to remove previously registered callback interface for MAP.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean unregisterMapCallback(com.nforetek.bt.aidl.UiCallbackMap cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterMapCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to download all messages from remote device.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link INfCallbackMap#onMapStateChanged onMapStateChanged} to be notified of subsequent profile state changes.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param folder
	 *		<p><blockquote>MAP_INBOX_OUTBOX		(int) 0
	 *		<br>MAP_INBOX_ONLY					(int) 1
	 *		<br>MAP_OUTBOX_ONLY					(int) 2</blockquote>
	 * @param isContentDownload
	 * <p><value>=false, download message list only
	 * <p><value>=true, download all messages including the contents, but this will set all messages to "read"
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqMapDownloadAllMessages(java.lang.String address, int folder, boolean isContentDownload) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(folder);
_data.writeInt(((isContentDownload)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_reqMapDownloadAllMessages, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to download single message from remote device.
	 * 
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link INfCallbackMap#onMapStateChanged onMapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.	
	 * @param folder
	 *		<p><blockquote>MAP_INBOX_ONLY		(int) 1
	 *		<br>MAP_OUTBOX_ONLY					(int) 2</blockquote>
	 * @param handle MAP handle
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqMapDownloadSingleMessage(java.lang.String address, int folder, java.lang.String handle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(folder);
_data.writeString(handle);
mRemote.transact(Stub.TRANSACTION_reqMapDownloadSingleMessage, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to download all messages from remote device and save to local database.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link INfCallbackMap#onMapStateChanged onMapStateChanged} to be notified of subsequent profile state changes.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param folder
	 *		<p><blockquote>MAP_INBOX_OUTBOX		(int) 0
	 *		<br>MAP_INBOX_ONLY					(int) 1
	 *		<br>MAP_OUTBOX_ONLY					(int) 2</blockquote>	
	 * @param isContentDownload
	 * <p><value>=false, download message list only
	 * <p><value>=true, download all messages including the contents, but this will set all messages to "read"
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean reqMapDownloadAllMessagesToDatabase(java.lang.String address, int folder, boolean isContentDownload) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(folder);
_data.writeInt(((isContentDownload)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_reqMapDownloadAllMessagesToDatabase, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to download single message from remote device and save to local database.
	 * 
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link INfCallbackMap#onMapStateChanged onMapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.	
	 * @param folder
	 *		<p><blockquote>MAP_INBOX_ONLY		(int) 1
	 *		<br>MAP_OUTBOX_ONLY					(int) 2</blockquote>
	 * @param handle MAP handle
	 * @return true to indicate the operation is successful, or false erroneous.		 
	 */
@Override public boolean reqMapDownloadSingleMessageToDatabase(java.lang.String address, int folder, java.lang.String handle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(folder);
_data.writeString(handle);
mRemote.transact(Stub.TRANSACTION_reqMapDownloadSingleMessageToDatabase, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to register notification when there is new message on remote device with given Bluetooth hardware address.
	 * Valid Bluetooth hardware addresses must be in a format such as "00:11:22:33:AA:BB".
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link INfCallbackMap#onMapStateChanged onMapStateChanged} to be notified if register notification success.
	 * and implement callback function {@link INfCallbackMap#onMapNewMessageReceivedEvent onMapNewMessageReceivedEvent}
	 * , {@link INfCallbackMap#onMapMemoryAvailableEvent onMapMemoryAvailableEvent}
	 * , {@link INfCallbackMap#onMapMessageSendingStatusEvent onMapMessageSendingStatusEvent}
	 * , {@link INfCallbackMap#onMapMessageDeliverStatusEvent onMapMessageDeliverStatusEvent}
	 * , {@link INfCallbackMap#onMapMessageShiftedEvent onMapMessageShiftedEvent}
	 * , {@link INfCallbackMap#onMapMessageDeletedEvent onMapMessageDeletedEvent}
	 * to be notified of receivced new message.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param downloadNewMessage if true, download the new message, including sender and message contents; if false, only notification will be sent
	 */
@Override public boolean reqMapRegisterNotification(java.lang.String address, boolean downloadNewMessage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(((downloadNewMessage)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_reqMapRegisterNotification, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to unregister new message notification on remote device with given Bluetooth hardware address.
	 * Valid Bluetooth hardware addresses must be in a format such as "00:11:22:33:AA:BB". 
	 *
	 * @param address valid Bluetooth MAC address.
	 */
@Override public void reqMapUnregisterNotification(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqMapUnregisterNotification, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Return true if the new message notification is registered on device with given address.
	 *
	 * @param address valid Bluetooth MAC address.	 
	 * @return true if registered.
	 */
@Override public boolean isMapNotificationRegistered(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_isMapNotificationRegistered, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to interrupt the ongoing download on remote device.
	 * 
	 * Clients should register and implement callback function {@link INfCallbackMap#onMapStateChanged onMapStateChanged} to be notified of subsequent result.    
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true if really try to interrupt.
	 */
@Override public boolean reqMapDownloadInterrupt(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqMapDownloadInterrupt, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to check if database is available for query
	 * Client should register and implement {@link INfCallbackMap#retMapDatabaseAvailable retMapDatabaseAvailable} 
	 * to be notified when database is available.
	 *
	 * @param address valid Bluetooth MAC address.	 
	 */
@Override public void reqMapDatabaseAvailable() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqMapDatabaseAvailable, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Request to delete MAP data by specific address
	 * Client should register and implement {@link INfCallbackMap#retMapDeleteDatabaseByAddressCompleted retMapDeleteDatabaseByAddressCompleted} 
	 * to be notified when database is available.
	 *
	 * @param address valid Bluetooth MAC address.	 
	 */
@Override public void reqMapDeleteDatabaseByAddress(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqMapDeleteDatabaseByAddress, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Request to clean database of MAP.
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link INfCallbackMap#retMapCleanDatabaseCompleted retMapCleanDatabaseCompleted} to be notified when database has been cleaned.	 
	 */
@Override public void reqMapCleanDatabase() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqMapCleanDatabase, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
	 * Request for the current download state of remote connected MAP device with given Bluetooth hardware address.
	 * Valid Bluetooth hardware addresses must be in a format such as "00:11:22:33:AA:BB".	 
	 *
	 * @param address valid Bluetooth MAC address of connected device.	 
	 * @return current state of MAP profile service.
	 */
@Override public int getMapCurrentState(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_getMapCurrentState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request for the current register state of remote connected MAP device with given Bluetooth hardware address.
	 * Valid Bluetooth hardware addresses must be in a format such as "00:11:22:33:AA:BB".	 
	 *
	 * @param address valid Bluetooth MAC address of connected device.	 
	 * @return current state of MAP profile service.
	 */
@Override public int getMapRegisterState(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_getMapRegisterState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to send message on remote device.
	 * 
	 * Clients should register and implement callback function {@link INfCallbackMap#retMapSendMessageCompleted retMapSendMessageCompleted} to be notified of subsequent result.    
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param message send context.
	 * @param target phone number of target.
	 */
@Override public boolean reqMapSendMessage(java.lang.String address, java.lang.String message, java.lang.String target) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(message);
_data.writeString(target);
mRemote.transact(Stub.TRANSACTION_reqMapSendMessage, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to delete message on remote device.
	 * 
	 * Clients should register and implement callback function {@link INfCallbackMap#retMapDeleteMessageCompleted retMapDeleteMessageCompleted} to delete a message in remote device.
	 * Suggest that the message handle should be updated by downloading message listing before deleting a message.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param folder which folder message download from. Possible values are
     *		<br>FOLDER_STRUCTURE_INBOX					(int) 0
	 * 		<br>FOLDER_STRUCTURE_SENT					(int) 1
	 * @param handle MAP handle
	 */
@Override public boolean reqMapDeleteMessage(java.lang.String address, int folder, java.lang.String handle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(folder);
_data.writeString(handle);
mRemote.transact(Stub.TRANSACTION_reqMapDeleteMessage, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Request to change read status of message.
	 * 
	 * Clients should register and implement callback function {@link INfCallbackMap#retMapChangeReadStatusCompleted retMapChangeReadStatusCompleted} to modify a read status in remote device.    
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param folder which folder message download from. Possible values are
     *		<br>FOLDER_STRUCTURE_INBOX					(int) 0
	 * 		<br>FOLDER_STRUCTURE_SENT					(int) 1
	 * @param handle MAP handle
	 * @param isReadStatus that "true" (=read) or "false" (=unread) for the "readStatus" indicator
	 */
@Override public boolean reqMapChangeReadStatus(java.lang.String address, int folder, java.lang.String handle, boolean isReadStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(folder);
_data.writeString(handle);
_data.writeInt(((isReadStatus)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_reqMapChangeReadStatus, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Set MAP download notify frequency. Will set to default value when ServiceManager restart.
	 * Default value is 0 means don't callback download notify. For example, if frequency is set to 5, every 5 contacts onPbapDownloadNofity will be notified.
	 *
	 * <br>Clients should register and implement callback function {@link INfCallbackMap#onMapDownloadNotify onMapDownloadNotify} to be notified of subsequent result.
	 * Callback will be invoked if below commands are issued     
	 * {@link INfCommandMap#reqMapDownloadAllMessages reqMapDownloadAllMessages} or
	 * {@link INfCommandMap#reqMapDownloadAllMessagesToDatabase reqMapDownloadAllMessagesToDatabase}
	 *
	 * @param frequency define the callback frequency.
	 * <p><value>=0 all messages would be downloaded first, and inserted to database. Only one callback would be invocated.
	 * <p><value>>0 Callbacks would be invocated every "frequency" messages have been downloaded and inserted to database. 
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean setMapDownloadNotify(int frequency) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(frequency);
mRemote.transact(Stub.TRANSACTION_setMapDownloadNotify, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// OPP
/**
	 * Register callback functions for OPP.
	 * <br>Call this function to register callback functions for OPP.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean registerOppCallback(com.nforetek.bt.aidl.UiCallbackOpp cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerOppCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Remove callback functions from OPP.
     * <br>Call this function to remove previously registered callback interface for OPP.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean unregisterOppCallback(com.nforetek.bt.aidl.UiCallbackOpp cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterOppCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Request to set Opp file storage path.
	 * <br>This is an asynchronous call: it will return immediately. 	 
	 *
	 * @param path is under sdcard path. For example, if path is set as /nfore, the actual path would be /sdcard/nfore.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
@Override public boolean setOppFilePath(java.lang.String path) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(path);
mRemote.transact(Stub.TRANSACTION_setOppFilePath, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Get Opp file storage path.
	 *
	 * @return Opp file storage path
	 */
@Override public java.lang.String getOppFilePath() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getOppFilePath, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Accept to receive file.
     * <br>Call this function to accept file transfer from remote device.
     * 
     * @param accept true or false to accept file transfer.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean reqOppAcceptReceiveFile(boolean accept) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((accept)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_reqOppAcceptReceiveFile, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
	 * Accept to receive file.
     * <br>Call this function to accept file transfer from remote device.
     * 
     * @param accept true or false to accept file transfer.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean reqOppInterruptReceiveFile() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqOppInterruptReceiveFile, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setTargetAddress(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_setTargetAddress, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String getTargetAddress() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTargetAddress, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void reqAvrcpUpdateSongStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqAvrcpUpdateSongStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Gatt
/** 
     * Check if Gatt Server service is ready.
     */
@Override public boolean isGattServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isGattServiceReady, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Register callback functions for Gatt Server.
     * <br>Call this function to register callback functions for Gatt Server.
     * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
     *
     * @param cb callback interface instance.
     * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean registerGattServerCallback(com.nforetek.bt.aidl.UiCallbackGattServer cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerGattServerCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Remove callback functions from Gatt Server.
     * <br>Call this function to remove previously registered callback interface for Gatt Server.
     * 
     * @param cb callback interface instance.
     * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean unregisterGattServerCallback(com.nforetek.bt.aidl.UiCallbackGattServer cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterGattServerCallback, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Get current connection state of the remote device.
     * 
     * @return current state of Gatt Server profile service.
     */
@Override public int getGattServerConnectionState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getGattServerConnectionState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Disconnects an established connection, or cancels a connection attempt
     * currently in progress.
     * <br>This is an asynchronous call: it will return immediately, and clients should register 
     * and implement callback functions {@link INfCallbackGattServer#onGattServerStateChanged onGattServerStateChanged} 
     * to be notified of subsequent profile state changes.
     * 
     * @param address Remote device address
     * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean reqGattServerDisconnect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_reqGattServerDisconnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Request to add Gatt service with service type and UUID.
     *
     * @param srvcType service type. Possible values are:
     *      <br>GATT_SERVICE_TYPE_PRIMARY                (int) 0
     *      <br>GATT_SERVICE_TYPE_SECONDARY              (int) 1
     * 
     * @param srvcUuid service UUID.
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean reqGattServerBeginServiceDeclaration(int srvcType, android.os.ParcelUuid srvcUuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(srvcType);
if ((srvcUuid!=null)) {
_data.writeInt(1);
srvcUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_reqGattServerBeginServiceDeclaration, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Request to add Gatt characteristic with UUID, properties and permissions with 
     * defined service.
     *
     * @param charUuid characteristic UUID.
     * @param properties Characteristic property. Possible values are:
     *      <br>GATT_CHARACTERISTIC_PROPERTY_BROADCAST              (int) 0x01
     *      <br>Characteristic is broadcastable.
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_READ                   (int) 0x02
     *      <br>Characteristic is readable.
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_WRITE_NO_RESPONSE      (int) 0x04
     *      <br>Characteristic can be written without response.
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_WRITE                  (int) 0x08
     *      <br>Characteristic can be written.
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_NOTIFY                 (int) 0x10
     *      <br>Characteristic supports notification
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_INDICATE               (int) 0x20
     *      <br>Characteristic supports indication
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_SIGNED_WRITE           (int) 0x30
     *      <br>Characteristic supports write with signature
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_EXTENDED_PROPS         (int) 0x40
     *      <br>Characteristic has extended properties
     *
     * @param permissions Characteristic permission. Attribute permissions 
     *  are a combination of access permissions, authentication
     *  permissions and authorization permissions. Possible values are:
     *      <br>GATT_CHARACTERISTIC_PERMISSION_READ                 (int) 0x01
     *      <br>Characteristic read permission
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_READ_ENCRYPTED        (int) 0x02
     *      <br>Allow encrypted read operations
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_READ_ENCRYPTED_MITM    (int) 0x04
     *      <br>Allow reading with man-in-the-middle protection
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_WRITE                  (int) 0x10
     *      <br>Characteristic write permission
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_WRITE_ENCRYPTED         (int) 0x20
     *      <br>Allow encrypted writes
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_WRITE_ENCRYPTED_MITM    (int) 0x40
     *      <br>Allow encrypted writes with man-in-the-middle protection
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_WRITE_SIGNED             (int) 0x80
     *      <br>Allow signed write operations
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_WRITE_SIGNED_MITM        (int) 0x100
     *      <br>Allow signed write operations with man-in-the-middle protection
     *
     *  For example, if this characteristic could be read/write with authentication permission,
     *  this value could be set as 0x22. (read encrypted and write encrypted)
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean reqGattServerAddCharacteristic(android.os.ParcelUuid charUuid, int properties, int permissions) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((charUuid!=null)) {
_data.writeInt(1);
charUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(properties);
_data.writeInt(permissions);
mRemote.transact(Stub.TRANSACTION_reqGattServerAddCharacteristic, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Request to add Gatt characteristic descriptor with UUID and permissions with 
     * defined characteristic.
     *
     * @param descUuid descriptor UUID.
     * @param permissions Descriptor permission. Attribute descriptor permissions 
     *  are a combination of access permissions, authentication
     *  permissions and authorization permissions. Possible values are:
     *      <br>GATT_DESCRIPTOR_PERMISSION_READ                 (int) 0x01
     *      <br>Descriptor read permission
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_READ_ENCRYPTED        (int) 0x02
     *      <br>Allow encrypted read operations
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_READ_ENCRYPTED_MITM    (int) 0x04
     *      <br>Allow reading with man-in-the-middle protection
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_WRITE                  (int) 0x10
     *      <br>Descriptor write permission
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_WRITE_ENCRYPTED         (int) 0x20
     *      <br>Allow encrypted writes
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_WRITE_ENCRYPTED_MITM    (int) 0x40
     *      <br>Allow encrypted writes with man-in-the-middle protection
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_WRITE_SIGNED             (int) 0x80
     *      <br>Allow signed write operations
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_WRITE_SIGNED_MITM        (int) 0x100
     *      <br>Allow signed write operations with man-in-the-middle protection
     *
     *  For example, if this characteristic descriptor could be read/write with authentication permission,
     *  this value could be set as 0x22. (read encrypted and write encrypted)
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean reqGattServerAddDescriptor(android.os.ParcelUuid descUuid, int permissions) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((descUuid!=null)) {
_data.writeInt(1);
descUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(permissions);
mRemote.transact(Stub.TRANSACTION_reqGattServerAddDescriptor, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Finish Service declaration. The service and related characteristics and descriptors 
     * are registered after end service declaration.
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean reqGattServerEndServiceDeclaration() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqGattServerEndServiceDeclaration, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Request to remove registered Gatt service with service type and UUID.
     * <br>This is an asynchronous call: it will return immediately, and clients should register 
     * and implement callback functions {@link INfCallbackGattServer#onGattServerServiceDeleted onGattServerServiceDeleted} 
     * to be notified of services deleted.
     *
     * @param srvcType service type.
     * @param srvcUuid service UUID.
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean reqGattServerRemoveService(int srvcType, android.os.ParcelUuid srvcUuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(srvcType);
if ((srvcUuid!=null)) {
_data.writeInt(1);
srvcUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_reqGattServerRemoveService, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Request to remove all registered Gatt services.
     * <br>This is an asynchronous call: it will return immediately, and clients should register 
     * and implement callback functions {@link INfCallbackGattServer#onGattServerServiceDeleted onGattServerServiceDeleted} 
     * to be notified of services deleted.
     *    
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean reqGattServerClearServices() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reqGattServerClearServices, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Request to start or finish advertisement broadcast
     * 
     * <br>This is an asynchronous call: it will return immediately, and clients should register 
     * and implement callback functions {@link INfCallbackGattServer#onGattServerStateChanged onGattServerStateChanged} 
     * to be notified of subsequent profile state changes.
     * @param listen start listen or not.
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean reqGattServerListen(boolean listen) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((listen)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_reqGattServerListen, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Request to send response with read and write characteristic request to Gatt clients.
     *  
     * @param address valid Bluetooth MAC address.
     * @param requestId The ID of the request that was received with the callback
     * @param status The status of the request to be sent to the remote devices
     *               Possible values are:
     *      <br>GATT_STATUS_SUCCESS                (int) 0x00
     *      <br>Operation success.
     *
     *      <br>GATT_STATUS_INVALID_HANDLE         (int) 0x01
     *      <br>Invalid Handle
     *
     *      <br>GATT_STATUS_READ_NOT_PERMIT        (int) 0x02
     *      <br>Read Not Permitted
     *
     *      <br>GATT_STATUS_WRITE_NOT_PERMIT       (int) 0x03
     *      <br>Write Not Permitted
     *
     *      <br>GATT_STATUS_INVALID_PDU            (int) 0x04
     *      <br>Invalid PDU
     *
     *      <br>GATT_STATUS_INSUF_AUTHENTICATION   (int) 0x05
     *      <br>Insufficient Authentication
     *
     *      <br>GATT_STATUS_REQ_NOT_SUPPORTED      (int) 0x06
     *      <br>Request Not Supported
     *
     *      <br>GATT_STATUS_INVALID_OFFSET         (int) 0x07
     *      <br>Invalid Offset
     *
     *      <br>GATT_STATUS_INSUF_AUTHORIZATION    (int) 0x08
     *      <br>Insufficient Authorization
     *
     *      <br>GATT_STATUS_PREPARE_Q_FULL         (int) 0x09
     *      <br>Prepare Queue Full
     *
     *      <br>GATT_STATUS_NOT_FOUND              (int) 0x0a
     *      <br>Attribute Not Found
     *
     *      <br>GATT_STATUS_NOT_LONG               (int) 0x0b
     *      <br>Attribute Not Long
     *
     *      <br>GATT_STATUS_INSUF_KEY_SIZE         (int) 0x0c
     *      <br>Insufficient Encryption Key Size
     *
     *      <br>GATT_STATUS_INVALID_ATTR_LEN       (int) 0x0d
     *      <br>Invalid Attribute Value Length
     *
     *      <br>GATT_STATUS_ERR_UNLIKELY           (int) 0x0e
     *      <br>Unlikely Error
     *
     *      <br>GATT_STATUS_INSUF_ENCRYPTION       (int) 0x0f
     *      <br>Insufficient Encryption
     *
     *      <br>GATT_STATUS_UNSUPPORT_GRP_TYPE     (int) 0x10
     *      <br>Unsupported Group Type.
     *
     *      <br>GATT_STATUS_INSUF_RESOURCE         (int) 0x11
     *      <br>Insufficient Resources
     *
     * @param offset Value offset for partial read/write response
     * @param value The value of the attribute that was read/written (optional)
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean reqGattServerSendResponse(java.lang.String address, int requestId, int status, int offset, byte[] value) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(requestId);
_data.writeInt(status);
_data.writeInt(offset);
_data.writeByteArray(value);
mRemote.transact(Stub.TRANSACTION_reqGattServerSendResponse, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Request to send characteristic notification values to Gatt clients.
     *  
     * @param address valid Bluetooth MAC address.
     * @param srvcType service type
     * @param srvcUuid service UUID
     * @param charUuid characteristic UUID
     * @param confirm true to request confirmation from the client (indication),
     *                false to send a notification
     * @param value The value to notify remote device.
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
@Override public boolean reqGattServerSendNotification(java.lang.String address, int srvcType, android.os.ParcelUuid srvcUuid, android.os.ParcelUuid charUuid, boolean confirm, byte[] value) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(srvcType);
if ((srvcUuid!=null)) {
_data.writeInt(1);
srvcUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((charUuid!=null)) {
_data.writeInt(1);
charUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((confirm)?(1):(0)));
_data.writeByteArray(value);
mRemote.transact(Stub.TRANSACTION_reqGattServerSendNotification, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Get GATT added service UUID list.
     *
     * @return Added Gatt service UUID list
     */
@Override public java.util.List<android.os.ParcelUuid> getGattAddedGattServiceUuidList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.os.ParcelUuid> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getGattAddedGattServiceUuidList, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.os.ParcelUuid.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Get GATT added characteristic UUID list.
     *
     * @param srvcUuid service UUID
     *
     * @return Added Gatt characteristic UUID list
     */
@Override public java.util.List<android.os.ParcelUuid> getGattAddedGattCharacteristicUuidList(android.os.ParcelUuid srvcUuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.os.ParcelUuid> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((srvcUuid!=null)) {
_data.writeInt(1);
srvcUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getGattAddedGattCharacteristicUuidList, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.os.ParcelUuid.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** 
     * Get GATT added descriptor UUID list.
     *
     * @param srvcUuid service UUID
     * @param charUuid characteristic UUID
     *
     * @return Added Gatt descriptor UUID list
     */
@Override public java.util.List<android.os.ParcelUuid> getGattAddedGattDescriptorUuidList(android.os.ParcelUuid srvcUuid, android.os.ParcelUuid charUuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.os.ParcelUuid> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((srvcUuid!=null)) {
_data.writeInt(1);
srvcUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((charUuid!=null)) {
_data.writeInt(1);
charUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getGattAddedGattDescriptorUuidList, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(android.os.ParcelUuid.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getUiServiceVersionName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_isAvrcpServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_isA2dpServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_isSppServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_isBluetoothServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_isHfpServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_isHidServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_isPbapServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_isOppServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_isMapServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_registerA2dpCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_unregisterA2dpCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_getA2dpConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_isA2dpConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_getA2dpConnectedAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_reqA2dpConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_reqA2dpDisconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_pauseA2dpRender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_startA2dpRender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_setA2dpLocalVolume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_setA2dpStreamType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_getA2dpStreamType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_registerAvrcpCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_unregisterAvrcpCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_getAvrcpConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_isAvrcpConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_getAvrcpConnectedAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
static final int TRANSACTION_reqAvrcpConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
static final int TRANSACTION_reqAvrcpDisconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
static final int TRANSACTION_isAvrcp13Supported = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
static final int TRANSACTION_isAvrcp14Supported = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
static final int TRANSACTION_reqAvrcpPlay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
static final int TRANSACTION_reqAvrcpStop = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
static final int TRANSACTION_reqAvrcpPause = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
static final int TRANSACTION_reqAvrcpForward = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
static final int TRANSACTION_reqAvrcpBackward = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
static final int TRANSACTION_reqAvrcpVolumeUp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
static final int TRANSACTION_reqAvrcpVolumeDown = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
static final int TRANSACTION_reqAvrcpStartFastForward = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
static final int TRANSACTION_reqAvrcpStopFastForward = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
static final int TRANSACTION_reqAvrcpStartRewind = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
static final int TRANSACTION_reqAvrcpStopRewind = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
static final int TRANSACTION_reqAvrcp13GetCapabilitiesSupportEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
static final int TRANSACTION_reqAvrcp13GetPlayerSettingAttributesList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
static final int TRANSACTION_reqAvrcp13GetPlayerSettingValuesList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
static final int TRANSACTION_reqAvrcp13GetPlayerSettingCurrentValues = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
static final int TRANSACTION_reqAvrcp13SetPlayerSettingValue = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
static final int TRANSACTION_reqAvrcp13GetElementAttributesPlaying = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
static final int TRANSACTION_reqAvrcp13GetPlayStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
static final int TRANSACTION_reqAvrcpRegisterEventWatcher = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
static final int TRANSACTION_reqAvrcpUnregisterEventWatcher = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
static final int TRANSACTION_reqAvrcp13NextGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
static final int TRANSACTION_reqAvrcp13PreviousGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
static final int TRANSACTION_isAvrcp14BrowsingChannelEstablished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
static final int TRANSACTION_reqAvrcp14SetAddressedPlayer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
static final int TRANSACTION_reqAvrcp14SetBrowsedPlayer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
static final int TRANSACTION_reqAvrcp14GetFolderItems = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
static final int TRANSACTION_reqAvrcp14ChangePath = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
static final int TRANSACTION_reqAvrcp14GetItemAttributes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
static final int TRANSACTION_reqAvrcp14PlaySelectedItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
static final int TRANSACTION_reqAvrcp14Search = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
static final int TRANSACTION_reqAvrcp14AddToNowPlaying = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
static final int TRANSACTION_reqAvrcp14SetAbsoluteVolume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
static final int TRANSACTION_registerBtCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
static final int TRANSACTION_unregisterBtCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 64);
static final int TRANSACTION_getNfServiceVersionName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 65);
static final int TRANSACTION_setBtEnable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 66);
static final int TRANSACTION_setBtDiscoverableTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 67);
static final int TRANSACTION_startBtDiscovery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 68);
static final int TRANSACTION_cancelBtDiscovery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 69);
static final int TRANSACTION_reqBtPair = (android.os.IBinder.FIRST_CALL_TRANSACTION + 70);
static final int TRANSACTION_reqBtUnpair = (android.os.IBinder.FIRST_CALL_TRANSACTION + 71);
static final int TRANSACTION_reqBtPairedDevices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 72);
static final int TRANSACTION_getBtLocalName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 73);
static final int TRANSACTION_getBtRemoteDeviceName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 74);
static final int TRANSACTION_getBtLocalAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 75);
static final int TRANSACTION_setBtLocalName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 76);
static final int TRANSACTION_isBtEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 77);
static final int TRANSACTION_getBtState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 78);
static final int TRANSACTION_isBtDiscovering = (android.os.IBinder.FIRST_CALL_TRANSACTION + 79);
static final int TRANSACTION_isBtDiscoverable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 80);
static final int TRANSACTION_setBtAutoConnectMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 81);
static final int TRANSACTION_isBtAutoConnectEnable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 82);
static final int TRANSACTION_reqBtConnectHfpA2dp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 83);
static final int TRANSACTION_reqBtDisconnectAll = (android.os.IBinder.FIRST_CALL_TRANSACTION + 84);
static final int TRANSACTION_getBtRemoteUuids = (android.os.IBinder.FIRST_CALL_TRANSACTION + 85);
static final int TRANSACTION_switchBtRoleMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 86);
static final int TRANSACTION_getBtRoleMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 87);
static final int TRANSACTION_registerHfpCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 88);
static final int TRANSACTION_unregisterHfpCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 89);
static final int TRANSACTION_getHfpConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 90);
static final int TRANSACTION_isHfpConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 91);
static final int TRANSACTION_getHfpConnectedAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 92);
static final int TRANSACTION_getHfpAudioConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 93);
static final int TRANSACTION_reqHfpConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 94);
static final int TRANSACTION_reqHfpDisconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 95);
static final int TRANSACTION_getHfpRemoteSignalStrength = (android.os.IBinder.FIRST_CALL_TRANSACTION + 96);
static final int TRANSACTION_getHfpCallList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 97);
static final int TRANSACTION_isHfpRemoteOnRoaming = (android.os.IBinder.FIRST_CALL_TRANSACTION + 98);
static final int TRANSACTION_getHfpRemoteBatteryIndicator = (android.os.IBinder.FIRST_CALL_TRANSACTION + 99);
static final int TRANSACTION_isHfpRemoteTelecomServiceOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 100);
static final int TRANSACTION_isHfpRemoteVoiceDialOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 101);
static final int TRANSACTION_reqHfpDialCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 102);
static final int TRANSACTION_reqHfpReDial = (android.os.IBinder.FIRST_CALL_TRANSACTION + 103);
static final int TRANSACTION_reqHfpMemoryDial = (android.os.IBinder.FIRST_CALL_TRANSACTION + 104);
static final int TRANSACTION_reqHfpAnswerCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 105);
static final int TRANSACTION_reqHfpRejectIncomingCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 106);
static final int TRANSACTION_reqHfpTerminateCurrentCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 107);
static final int TRANSACTION_reqHfpSendDtmf = (android.os.IBinder.FIRST_CALL_TRANSACTION + 108);
static final int TRANSACTION_reqHfpAudioTransferToCarkit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 109);
static final int TRANSACTION_reqHfpAudioTransferToPhone = (android.os.IBinder.FIRST_CALL_TRANSACTION + 110);
static final int TRANSACTION_getHfpRemoteNetworkOperator = (android.os.IBinder.FIRST_CALL_TRANSACTION + 111);
static final int TRANSACTION_getHfpRemoteSubscriberNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 112);
static final int TRANSACTION_reqHfpVoiceDial = (android.os.IBinder.FIRST_CALL_TRANSACTION + 113);
static final int TRANSACTION_pauseHfpRender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 114);
static final int TRANSACTION_startHfpRender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 115);
static final int TRANSACTION_isHfpMicMute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 116);
static final int TRANSACTION_muteHfpMic = (android.os.IBinder.FIRST_CALL_TRANSACTION + 117);
static final int TRANSACTION_isHfpInBandRingtoneSupport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 118);
static final int TRANSACTION_registerPbapCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 119);
static final int TRANSACTION_unregisterPbapCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 120);
static final int TRANSACTION_getPbapConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 121);
static final int TRANSACTION_isPbapDownloading = (android.os.IBinder.FIRST_CALL_TRANSACTION + 122);
static final int TRANSACTION_getPbapDownloadingAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 123);
static final int TRANSACTION_reqPbapDownload = (android.os.IBinder.FIRST_CALL_TRANSACTION + 124);
static final int TRANSACTION_reqPbapDownloadRange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 125);
static final int TRANSACTION_reqPbapDownloadToDatabase = (android.os.IBinder.FIRST_CALL_TRANSACTION + 126);
static final int TRANSACTION_reqPbapDownloadRangeToDatabase = (android.os.IBinder.FIRST_CALL_TRANSACTION + 127);
static final int TRANSACTION_reqPbapDownloadToContactsProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 128);
static final int TRANSACTION_reqPbapDownloadRangeToContactsProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 129);
static final int TRANSACTION_reqPbapDatabaseQueryNameByNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 130);
static final int TRANSACTION_reqPbapDatabaseQueryNameByPartialNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 131);
static final int TRANSACTION_reqPbapDatabaseAvailable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 132);
static final int TRANSACTION_reqPbapDeleteDatabaseByAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 133);
static final int TRANSACTION_reqPbapCleanDatabase = (android.os.IBinder.FIRST_CALL_TRANSACTION + 134);
static final int TRANSACTION_reqPbapDownloadInterrupt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 135);
static final int TRANSACTION_setPbapDownloadNotify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 136);
static final int TRANSACTION_registerSppCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 137);
static final int TRANSACTION_unregisterSppCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 138);
static final int TRANSACTION_reqSppConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 139);
static final int TRANSACTION_reqSppDisconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 140);
static final int TRANSACTION_reqSppConnectedDeviceAddressList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 141);
static final int TRANSACTION_isSppConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 142);
static final int TRANSACTION_reqSppSendData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 143);
static final int TRANSACTION_registerHidCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 144);
static final int TRANSACTION_unregisterHidCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 145);
static final int TRANSACTION_getHidConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 146);
static final int TRANSACTION_isHidConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 147);
static final int TRANSACTION_getHidConnectedAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 148);
static final int TRANSACTION_reqHidConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 149);
static final int TRANSACTION_reqHidDisconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 150);
static final int TRANSACTION_reqSendHidMouseCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 151);
static final int TRANSACTION_reqSendHidVirtualKeyCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 152);
static final int TRANSACTION_registerMapCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 153);
static final int TRANSACTION_unregisterMapCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 154);
static final int TRANSACTION_reqMapDownloadAllMessages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 155);
static final int TRANSACTION_reqMapDownloadSingleMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 156);
static final int TRANSACTION_reqMapDownloadAllMessagesToDatabase = (android.os.IBinder.FIRST_CALL_TRANSACTION + 157);
static final int TRANSACTION_reqMapDownloadSingleMessageToDatabase = (android.os.IBinder.FIRST_CALL_TRANSACTION + 158);
static final int TRANSACTION_reqMapRegisterNotification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 159);
static final int TRANSACTION_reqMapUnregisterNotification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 160);
static final int TRANSACTION_isMapNotificationRegistered = (android.os.IBinder.FIRST_CALL_TRANSACTION + 161);
static final int TRANSACTION_reqMapDownloadInterrupt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 162);
static final int TRANSACTION_reqMapDatabaseAvailable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 163);
static final int TRANSACTION_reqMapDeleteDatabaseByAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 164);
static final int TRANSACTION_reqMapCleanDatabase = (android.os.IBinder.FIRST_CALL_TRANSACTION + 165);
static final int TRANSACTION_getMapCurrentState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 166);
static final int TRANSACTION_getMapRegisterState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 167);
static final int TRANSACTION_reqMapSendMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 168);
static final int TRANSACTION_reqMapDeleteMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 169);
static final int TRANSACTION_reqMapChangeReadStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 170);
static final int TRANSACTION_setMapDownloadNotify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 171);
static final int TRANSACTION_registerOppCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 172);
static final int TRANSACTION_unregisterOppCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 173);
static final int TRANSACTION_setOppFilePath = (android.os.IBinder.FIRST_CALL_TRANSACTION + 174);
static final int TRANSACTION_getOppFilePath = (android.os.IBinder.FIRST_CALL_TRANSACTION + 175);
static final int TRANSACTION_reqOppAcceptReceiveFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 176);
static final int TRANSACTION_reqOppInterruptReceiveFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 177);
static final int TRANSACTION_setTargetAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 178);
static final int TRANSACTION_getTargetAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 179);
static final int TRANSACTION_reqAvrcpUpdateSongStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 180);
static final int TRANSACTION_isGattServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 181);
static final int TRANSACTION_registerGattServerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 182);
static final int TRANSACTION_unregisterGattServerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 183);
static final int TRANSACTION_getGattServerConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 184);
static final int TRANSACTION_reqGattServerDisconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 185);
static final int TRANSACTION_reqGattServerBeginServiceDeclaration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 186);
static final int TRANSACTION_reqGattServerAddCharacteristic = (android.os.IBinder.FIRST_CALL_TRANSACTION + 187);
static final int TRANSACTION_reqGattServerAddDescriptor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 188);
static final int TRANSACTION_reqGattServerEndServiceDeclaration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 189);
static final int TRANSACTION_reqGattServerRemoveService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 190);
static final int TRANSACTION_reqGattServerClearServices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 191);
static final int TRANSACTION_reqGattServerListen = (android.os.IBinder.FIRST_CALL_TRANSACTION + 192);
static final int TRANSACTION_reqGattServerSendResponse = (android.os.IBinder.FIRST_CALL_TRANSACTION + 193);
static final int TRANSACTION_reqGattServerSendNotification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 194);
static final int TRANSACTION_getGattAddedGattServiceUuidList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 195);
static final int TRANSACTION_getGattAddedGattCharacteristicUuidList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 196);
static final int TRANSACTION_getGattAddedGattDescriptorUuidList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 197);
}
public java.lang.String getUiServiceVersionName() throws android.os.RemoteException;
/** 
	 * Check if AVRCP service is ready.
	 */
public boolean isAvrcpServiceReady() throws android.os.RemoteException;
/** 
	 * Check if A2DP service is ready.
	 */
public boolean isA2dpServiceReady() throws android.os.RemoteException;
/** 
	 * Check if SPP service is ready.
	 */
public boolean isSppServiceReady() throws android.os.RemoteException;
/** 
	 * Check if Bluetooth service is ready.
	 */
public boolean isBluetoothServiceReady() throws android.os.RemoteException;
/** 
	 * Check if HFP service is ready.
	 */
public boolean isHfpServiceReady() throws android.os.RemoteException;
/** 
	 * Check if HID service is ready.
	 */
public boolean isHidServiceReady() throws android.os.RemoteException;
/** 
	 * Check if PBAP service is ready.
	 */
public boolean isPbapServiceReady() throws android.os.RemoteException;
/** 
	 * Check if Opp service is ready.
	 */
public boolean isOppServiceReady() throws android.os.RemoteException;
/** 
	 * Check if MAP service is ready.
	 */
public boolean isMapServiceReady() throws android.os.RemoteException;
// A2DP
/** 
	 * Register callback functions for A2DP.
	 * <br>Call this function to register callback functions for A2DP.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean registerA2dpCallback(com.nforetek.bt.aidl.UiCallbackA2dp cb) throws android.os.RemoteException;
/** 
	 * Remove callback functions from A2DP.
     * <br>Call this function to remove previously registered callback interface for A2DP.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean unregisterA2dpCallback(com.nforetek.bt.aidl.UiCallbackA2dp cb) throws android.os.RemoteException;
/** 
	 * Get current connection state of the remote device.
	 *
	 * @return current state of A2DP profile service.
	 */
public int getA2dpConnectionState() throws android.os.RemoteException;
/** 
	 * Check if local device is A2DP connected with remote device.
	 *
	 * @return true to indicate A2DP is connected, or false disconnected.
	 */
public boolean isA2dpConnected() throws android.os.RemoteException;
/** 
	 * Get the Bluetooth hardware address of A2DP connected remote device.
	 *
	 * @return Bluetooth hardware address as string if there is a connected A2DP device, or 
	 * <code>DEFAULT_ADDRESS</code> 00:00:00:00:00:00.
	 */
public java.lang.String getA2dpConnectedAddress() throws android.os.RemoteException;
/** 
	 * Request to connect A2DP to the remote device.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged} to be notified of subsequent profile state changes.
	 * 
	 * <p>There is no guarantee that A2DP will be connected and the sequence of state changed callback of profiles! 
	 * <br>This depends on the behavior of connected device.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqA2dpConnect(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request to disconnect A2DP to the remote device.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged} to be notified of subsequent profile state changes.
	 * 
	 * <p>There is no guarantee that A2DP will be disconnected and the sequence of state changed callback of profiles! 
	 * <br>This depends on the behavior of connected device.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqA2dpDisconnect(java.lang.String address) throws android.os.RemoteException;
/**
	 * Stop send A2DP stream data to audio track.
	 */
public void pauseA2dpRender() throws android.os.RemoteException;
/**
	 * Start send A2DP stream data to audio track.
	 */
public void startA2dpRender() throws android.os.RemoteException;
/** 
	 * Request to set the volume of A2DP streaming music locally.
	 * <br>This is an asynchronous call: it will return immediately.
	 *
	 * @param vol volumn level to set. The possible values are from 0.0f to 1.0f.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean setA2dpLocalVolume(float vol) throws android.os.RemoteException;
/** 
	 * Request to set the stream type of audio system.
	 * Have to set each time after A2DP is connected.
	 * Default value is AudioManager.STREAM_MUSIC (3)
	 * If need to change stream type during A2DP connected, have to use {@link INfCommandA2dp#pauseA2dpRender pauseA2dpRender} first
	 * and then use {@link INfCommandA2dp#startA2dpRender startA2dpRender} after set stream type.
	 *
	 * <br>This is an asynchronous call: it will return immediately.
	 *
	 * @param type stream type to set.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean setA2dpStreamType(int type) throws android.os.RemoteException;
/** 
	 * Get the current stream type of audio system.
	 *
	 * @return current stream type of audio system.
	 */
public int getA2dpStreamType() throws android.os.RemoteException;
// AVRCP
/** 
	 * Register callback functions for AVRCP.
	 * <br>Call this function to register callback functions for AVRCP.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean registerAvrcpCallback(com.nforetek.bt.aidl.UiCallbackAvrcp cb) throws android.os.RemoteException;
/** 
	 * Remove callback functions from AVRCP.
     * <br>Call this function to remove previously registered callback interface for AVRCP.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean unregisterAvrcpCallback(com.nforetek.bt.aidl.UiCallbackAvrcp cb) throws android.os.RemoteException;
/** 
	 * Get current connection state of the remote device.
	 *
	 * @return current state of AVRCP profile service.
	 */
public int getAvrcpConnectionState() throws android.os.RemoteException;
/** 
	 * Check if local device is AVRCP connected with remote device.
	 *
	 * @return true to indicate AVRCP is connected, or false disconnected.
	 */
public boolean isAvrcpConnected() throws android.os.RemoteException;
/** 
	 * Get the Bluetooth hardware address of AVRCP connected remote device.
	 * 
	 */
public java.lang.String getAvrcpConnectedAddress() throws android.os.RemoteException;
/** 
	 * Request to connect AVRCP to the remote device.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#onAvrcpStateChanged onAvrcpStateChanged} to be notified of subsequent profile state changes.
	 * 
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpConnect(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request to disconnect AVRCP to the remote device.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#onAvrcpStateChanged onAvrcpStateChanged} to be notified of subsequent profile state changes.
	 * 	 
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpDisconnect(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request if AVRCP 1.3 is supported by remote device.
	 *
	 * <p>The requested address must be the paired device and is connected currently.	 
	 *
	 * @param address valid Bluetooth MAC address of paired and connected AVRCP device.
	 * @return false if the device dose not support version 1.3 or is not connected currently.  
	 */
public boolean isAvrcp13Supported(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request if AVRCP 1.4 is supported by remote device.
	 *
	 * <p>The requested address must be the paired device and is connected currently.	 
	 *
	 * @param address valid Bluetooth MAC address of paired and connected AVRCP device.
	 * @return false if the device dose not support version 1.4 or is not connected currently.  
	 */
public boolean isAvrcp14Supported(java.lang.String address) throws android.os.RemoteException;
/* ==================================================================================================================================== 
	 * AVRCP v1.0
	 *//** 
	 * Request A2DP/AVRCP connected remote device to do the "Play" operation.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged} 
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpPlay() throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to do the "Stop" operation.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged} 
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpStop() throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to do the "Pause" operation.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged} 
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpPause() throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to do the "Forward" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpForward() throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to do the "Backward" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpBackward() throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to do the "Volume Up" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpVolumeUp() throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to do the "Volume Down" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpVolumeDown() throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to start the "Fast Forward" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpStartFastForward() throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to stop the "Fast Forward" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpStopFastForward() throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to start the "Rewind" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpStartRewind() throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to stop the "Rewind" operation.
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpStopRewind() throws android.os.RemoteException;
/* ==================================================================================================================================== 
	 * AVRCP v1.3
	 *//** 
	 * Request to get the supported events of capabilities from A2DP/AVRCP connected remote device. 
	 * This is sent by CT to inquire capabilities of the peer device.
	 *
	 * <p>This requests the list of events supported by the remote device. Remote device is expected to respond with all the events supported 
	 * including the mandatory events defined in the AVRCP v1.3 specification.	 
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13CapabilitiesSupportEvent retAvrcp13CapabilitiesSupportEvent} and 
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp13GetCapabilitiesSupportEvent() throws android.os.RemoteException;
/** 
	 * Request to get the supported player application setting attributes from A2DP/AVRCP connected remote device. 
	 *
	 * <p>The list of reserved player application setting attributes is provided in Appendix F of AVRCP v1.3 specification. 
	 * <br>It is expected that a target device may have additional attributes not defined as part of the specification.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13PlayerSettingAttributesList retAvrcp13PlayerSettingAttributesList} and 
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp13GetPlayerSettingAttributesList() throws android.os.RemoteException;
/** 
	 * Request to get the set of possible values for the requested player application setting attribute 
	 * from A2DP/AVRCP connected remote device. 
	 *
	 * <p>The list of reserved player application setting attributes and their values are provided in Appendix F of AVRCP v1.3 specification. 
	 * <br>It is expected that a target device may have additional attribute values not defined as part of the specification.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13PlayerSettingValuesList retAvrcp13PlayerSettingValuesList} and 
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @param attributeId the requesting attribute ID. Possible values are:
	 * 		<blockquote><b>AVRCP_SETTING_ATTRIBUTE_ID_EQUALIZER</b>	(byte) 0x01
	 *		<br><b>AVRCP_SETTING_ATTRIBUTE_ID_REPEAT_MODE</b>			(byte) 0x02
	 *		<br><b>AVRCP_SETTING_ATTRIBUTE_ID_SHUFFLE</b>				(byte) 0x03
	 *		<br><b>AVRCP_SETTING_ATTRIBUTE_ID_SCAN</b>					(byte) 0x04</blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp13GetPlayerSettingValuesList(byte attributeId) throws android.os.RemoteException;
/** 
	 * Request to get the current set values from A2DP/AVRCP connected remote device
	 * for the provided player application setting attribute. 
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13PlayerSettingCurrentValues retAvrcp13PlayerSettingCurrentValues} and 
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp13GetPlayerSettingCurrentValues() throws android.os.RemoteException;
/** 
	 * Request to set the player application setting of player application setting value on A2DP/AVRCP connected remote device 
	 * for the corresponding defined PlayerApplicationSettingAttribute. 
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13SetPlayerSettingValueSuccess retAvrcp13SetPlayerSettingValueSuccess} and 
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @param attributeId the requesting attribute ID. Possible values are:
	 * 		<blockquote><b>AVRCP_SETTING_ATTRIBUTE_ID_EQUALIZER</b>	(byte) 0x01
	 *		<br><b>AVRCP_SETTING_ATTRIBUTE_ID_REPEAT_MODE</b>			(byte) 0x02
	 *		<br><b>AVRCP_SETTING_ATTRIBUTE_ID_SHUFFLE</b>				(byte) 0x03
	 *		<br><b>AVRCP_SETTING_ATTRIBUTE_ID_SCAN</b>					(byte) 0x04</blockquote>
	 * @param valueId the setting value. Possible values are:
	 * 		<blockquote>For <b>AVRCP_SETTING_ATTRIBUTE_ID_EQUALIZER</b></blockquote>
	 *			<blockquote><blockquote><b>AVRCP_SETTING_VALUE_ID_EQUALIZER_OFF</b>	(byte) 0x01
	 *			<br><b>AVRCP_SETTING_VALUE_ID_EQUALIZER_ON</b>						(byte) 0x02</blockquote></blockquote>
	 *		<blockquote>For <b>AVRCP_SETTING_ATTRIBUTE_ID_REPEAT_MODE</b></blockquote>
	 *			<blockquote><blockquote><b>AVRCP_SETTING_VALUE_ID_REPEAT_OFF</b>	(byte) 0x01
	 *			<br><b>AVRCP_SETTING_VALUE_ID_REPEAT_SINGLE</b>						(byte) 0x02
	 *			<br><b>AVRCP_SETTING_VALUE_ID_REPEAT_ALL</b>						(byte) 0x03
	 *			<br><b>AVRCP_SETTING_VALUE_ID_REPEAT_GROUP</b>						(byte) 0x04</blockquote></blockquote>
	 *		<blockquote>For <b>AVRCP_SETTING_ATTRIBUTE_ID_SHUFFLE</b></blockquote>
	 *			<blockquote><blockquote><b>AVRCP_SETTING_VALUE_ID_SHUFFLE_OFF</b>	(byte) 0x01
	 *			<br><b>AVRCP_SETTING_VALUE_ID_SHUFFLE_ALL</b>						(byte) 0x02
	 *			<br><b>AVRCP_SETTING_VALUE_ID_SHUFFLE_GROUP</b>						(byte) 0x03</blockquote></blockquote>
	 *		<blockquote>For <b>AVRCP_SETTING_ATTRIBUTE_ID_SCAN</b></blockquote>
	 *			<blockquote><blockquote><b>AVRCP_SETTING_VALUE_ID_SCAN_OFF</b>		(byte) 0x01
	 *			<br><b>AVRCP_SETTING_VALUE_ID_SCAN_ALL</b>							(byte) 0x02
	 *			<br><b>AVRCP_SETTING_VALUE_ID_SCAN_GROUP</b>						(byte) 0x03</blockquote></blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp13SetPlayerSettingValue(byte attributeId, byte valueId) throws android.os.RemoteException;
/** 
	 * Request to get the attributes of the element specified in the parameter 
	 * from A2DP/AVRCP connected remote device
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13ElementAttributesPlaying retAvrcp13ElementAttributesPlaying} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 * 
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp13GetElementAttributesPlaying() throws android.os.RemoteException;
/** 
	 * Request to get the status of the currently playing media  
	 * from A2DP/AVRCP connected remote device
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp13PlayStatus retAvrcp13PlayStatus} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *	 
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp13GetPlayStatus() throws android.os.RemoteException;
/** 
	 * Request to register with A2DP/AVRCP connected remote device
	 * to receive notifications asynchronously based on specific events occurring. 
	 * 
	 * <p>The events registered would be kept on remote device until another
	 * {@link UiCommandAvrcp#reqAvrcpUnregisterEventWatcher reqAvrcpUnregisterEventWatcher} is called.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * <blockquote>{@link UiCallbackAvrcp#onAvrcp13EventPlaybackStatusChanged onAvrcp13EventPlaybackStatusChanged},
	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventTrackChanged onAvrcp13EventTrackChanged},
	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventTrackReachedEnd onAvrcp13EventTrackReachedEnd},
	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventTrackReachedStart onAvrcp13EventTrackReachedStart},
	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventPlaybackPosChanged onAvrcp13EventPlaybackPosChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventBatteryStatusChanged onAvrcp13EventBatteryStatusChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventSystemStatusChanged onAvrcp13EventSystemStatusChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp13EventPlayerSettingChanged onAvrcp13EventPlayerSettingChanged},
 	 * <br>v1.4
 	 * <br>{@link UiCallbackAvrcp#onAvrcp14EventNowPlayingContentChanged onAvrcp14EventNowPlayingContentChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp14EventAvailablePlayerChanged onAvrcp14EventAvailablePlayerChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp14EventAddressedPlayerChanged onAvrcp14EventAddressedPlayerChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp14EventUidsChanged onAvrcp14EventUidsChanged},
 	 * <br>{@link UiCallbackAvrcp#onAvrcp14EventVolumeChanged onAvrcp14EventVolumeChanged}, and
	 * <br>{@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} </blockquote>
	 * to be notified of subsequent result.
	 * <br>Each corresponding callback would be invoked once immediately after the event has been registered successfully. 
	 *
	 *  
	 * @param eventId the registering event ID. Possible values are:
	 *		<blockquote><b>AVRCP_EVENT_ID_PLAYBACK_STATUS_CHANGED</b>		(byte) 0x01
	 *		<br><b>AVRCP_EVENT_ID_TRACK_CHANGED</b>							(byte) 0x02
	 *		<br><b>AVRCP_EVENT_ID_TRACK_REACHED_END</b>						(byte) 0x03
	 *		<br><b>AVRCP_EVENT_ID_TRACK_REACHED_START</b>					(byte) 0x04
	 *		<br><b>AVRCP_EVENT_ID_PLAYBACK_POS_CHANGED</b>					(byte) 0x05
	 *		<br><b>AVRCP_EVENT_ID_BATT_STATUS_CHANGED</b>					(byte) 0x06
	 *		<br><b>AVRCP_EVENT_ID_SYSTEM_STATUS_CHANGED</b>					(byte) 0x07
	 *		<br><b>AVRCP_EVENT_ID_PLAYER_APPLICATION_SETTING_CHANGED</b>	(byte) 0x08
	 *		<br>v1.4
	 *		<br><b>AVRCP_EVENT_ID_NOW_PLAYING_CONTENT_CHANGED</b>			(byte) 0x09
	 *		<br><b>AVRCP_EVENT_ID_AVAILABLE_PLAYERS_CHANGED</b>				(byte) 0x0a
	 *		<br><b>AVRCP_EVENT_ID_ADDRESSED_PLAYER_CHANGED</b>				(byte) 0x0b
	 *		<br><b>AVRCP_EVENT_ID_UIDS_CHANGED</b>							(byte) 0x0c
	 *		<br><b>AVRCP_EVENT_ID_VOLUME_CHANGED</b>						(byte) 0x0d</blockquote>		
	 * @param interval the update interval in second. 
	 * <br>This parameter applicable only for <b>AVRCP_EVENT_ID_PLAYBACK_POS_CHANGED</b>. 
	 * For other events, this parameter is <b>ignored</b> !
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpRegisterEventWatcher(byte eventId, long interval) throws android.os.RemoteException;
/** 
	 * Request to unregister the specific events with A2DP/AVRCP connected remote device.
	 *
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @param eventId the unregistering event ID. Possible values are
	 *		<blockquote><b>AVRCP_EVENT_ID_PLAYBACK_STATUS_CHANGED</b>		(byte) 0x01
	 *		<br><b>AVRCP_EVENT_ID_TRACK_CHANGED</b>							(byte) 0x02
	 *		<br><b>AVRCP_EVENT_ID_TRACK_REACHED_END</b>						(byte) 0x03
	 *		<br><b>AVRCP_EVENT_ID_TRACK_REACHED_START</b>					(byte) 0x04
	 *		<br><b>AVRCP_EVENT_ID_PLAYBACK_POS_CHANGED</b>					(byte) 0x05
	 *		<br><b>AVRCP_EVENT_ID_BATT_STATUS_CHANGED</b>					(byte) 0x06
	 *		<br><b>AVRCP_EVENT_ID_SYSTEM_STATUS_CHANGED</b>					(byte) 0x07
	 *		<br><b>AVRCP_EVENT_ID_PLAYER_APPLICATION_SETTING_CHANGED</b>	(byte) 0x08
	 *		<br>v1.4	 
	 *		<br><b>AVRCP_EVENT_ID_NOW_PLAYING_CONTENT_CHANGED</b>			(byte) 0x09
	 *		<br><b>AVRCP_EVENT_ID_AVAILABLE_PLAYERS_CHANGED</b>				(byte) 0x0a
	 *		<br><b>AVRCP_EVENT_ID_ADDRESSED_PLAYER_CHANGED</b>				(byte) 0x0b
	 *		<br><b>AVRCP_EVENT_ID_UIDS_CHANGED</b>							(byte) 0x0c
	 *		<br><b>AVRCP_EVENT_ID_VOLUME_CHANGED</b>						(byte) 0x0d</blockquote>		
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcpUnregisterEventWatcher(byte eventId) throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to move to the first song in the next group.
	 * 
	 * <p>This is an asynchronous call: it will return immediately.
	 * 
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp13NextGroup() throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to move to the first song in the previous group.
	 *
	 * <p>This is an asynchronous call: it will return immediately.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp13PreviousGroup() throws android.os.RemoteException;
/* ==================================================================================================================================== 
	 * AVRCP v1.4
	 *//** 
	 * Request if A2DP/AVRCP connected remote device has browsing channel established. 
	 *
	 * @return true to indicate the remote device has browsing channel.
	 */
public boolean isAvrcp14BrowsingChannelEstablished() throws android.os.RemoteException;
/** 
	 * Request to Uiorm the A2DP/AVRCP connected remote device of which media player we wishes to control.
	 * <p>The player is selected by its "Player Id".
	 * <br>When the addressed player is changed, whether locally on the remote device or explicitly by us, 
	 * the remote device shall complete notifications following the mechanism described in section 6.9.2 of AVRCP v1.4 specification. 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14SetAddressedPlayerSuccess retAvrcp14SetAddressedPlayerSuccess} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @param playerId the selected player ID of 2 octets. 
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp14SetAddressedPlayer(int playerId) throws android.os.RemoteException;
/** 
	 * Request the A2DP/AVRCP connected remote device to route browsing commands to which player.
	 *
	 * <p>The player to which AVRCP shall route browsing commands is the browsed player. 
	 * <br>This command shall be sent successfully before any other commands are sent on the browsing channel except 
	 * {@link UiCommandAvrcp#reqAvrcp14GetFolderItems reqAvrcp14GetFolderItems}
	 * in the Media Player List scope. 
	 * <br>If the browsed player has become unavailable this command shall be sent successfully again before further commands are sent on the browsing channel. 
	 * <br>Some players may support browsing only when set as the Addressed Player.
	 * <p>The player is selected by its "Player Id".
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14SetBrowsedPlayerSuccess retAvrcp14SetBrowsedPlayerSuccess} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param playerId the selected player ID of 2 octets. 
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp14SetBrowsedPlayer(int playerId) throws android.os.RemoteException;
/** 
	 * Request to retrieve a listing of the contents of a folder on A2DP/AVRCP connected remote device.
	 *
	 * <p>The folder is the representation of available media players, virtual file system, the last searching result, or the playing list.
	 * Should not issue this command to an empty folder.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14FolderItems retAvrcp14FolderItems} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param scopeId the requesting folder ID. Possible values are:
	 * 		<blockquote><b>AVRCP_SCOPE_ID_MEDIA_PLAYER</b>	(byte) 0x00
	 *		<br><b>AVRCP_SCOPE_ID_VFS</b>						(byte) 0x01
	 *		<br><b>AVRCP_SCOPE_ID_SEARCH</b>					(byte) 0x02
	 *		<br><b>AVRCP_SCOPE_ID_NOW_PLAYING</b>				(byte) 0x03</blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp14GetFolderItems(byte scopeId) throws android.os.RemoteException;
/** 
	 * Request to navigate the virtual filesystem on A2DP/AVRCP connected remote device. 
	 * <p>This command allows us to navigate one level up or down in the virtual filesystem.
	 * <p>Uid counters parameter is used to make sure that our uid cache is consistent with what remote device has currently. 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14ChangePathSuccess retAvrcp14ChangePathSuccess} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param uidCounter the value of uid counter we have.
	 * @param uid The UID of the folder to navigate to. This may be retrieved via a 
	 * {@link UiCommandAvrcp#reqAvrcp14GetFolderItems reqAvrcp14GetFolderItems} command. 
	 * <br>If the navigation command is "Folder Up" this field is <b>reserved</b>.	 
	 * @param direction the requesting operation on selested UID. Possible values are:
	 * 		<blockquote><b>AVRCP_FOLDER_DIRECTION_ID_UP</b>		(byte) 0x00
	 *		<br><b>AVRCP_FOLDER_DIRECTION_ID_DOWN</b>			(byte) 0x01</blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp14ChangePath(int uidCounter, long uid, byte direction) throws android.os.RemoteException;
/** 
	 * Request to retrieve the metadata attributes for a particular media element item or folder item 
	 * on A2DP/AVRCP connected remote device. 
	 * <p>When the remote device supports this command, we shall use this command and not {@link #reqAvrcp13GetElementAttributesPlaying reqAvrcp13GetElementAttributesPlaying}. 
	 * <br>To retrieve the Metadata for the currently playing track we should register to receive Track Changed Notifications. 
	 * <br>This shall then provide the UID of the currently playing track, which can be used in the scope of the Now Playing folder.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14ItemAttributes retAvrcp14ItemAttributes} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param scopeId the requesting folder ID. Possible values are
	 *		<blockquote><b>AVRCP_SCOPE_ID_VFS</b>		(byte) 0x01
	 *		<br><b>AVRCP_SCOPE_ID_SEARCH</b>			(byte) 0x02
	 *		<br><b>AVRCP_SCOPE_ID_NOW_PLAYING</b>		(byte) 0x03</blockquote>
	 * @param uidCounter the value of uid counter we have.
	 * @param uid The UID of the media element item or folder item to return the attributes for. UID 0 shall not be used.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp14GetItemAttributes(byte scopeId, int uidCounter, long uid) throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to starts playing an item indicated by the UID.
	 * It is routed to the Addressed Player. 
	 * <p>If a UID changed event has happened but not received by local yet, the previous UID counter may be sent. 
	 * In this case a failure status shall be returned.
	 * <p>Request this command with the scope parameter of 
	 *		<blockquote><b>AVRCP_SCOPE_ID_VFS</b>			(byte) 0x01 or 
	 * 		<br><b>AVRCP_SCOPE_ID_SEARCH</b>				(byte) 0x02</blockquote>
	 * shall result in the NowPlaying folder being invalidated. 
	 * <br>The old content may not be valid any more or may contain additional items. 
	 * <p>What is put in the NowPlaying folder depends on both the media player and its state, however the item selected by us shall be included.
	 * <p>Request this command with the scope parameter of 
	 * 		<blockquote><b>AVRCP_SCOPE_ID_NOW_PLAYING</b>	(byte) 0x03</blockquote>
	 * should not change the contents of the NowPlaying Folder, the only effect is that the new item is played.
	 * <p>Never request this command with the scope parameter 
	 * 		<blockquote><b>AVRCP_SCOPE_ID_MEDIA_PLAYER</b>	(byte) 0x00.</blockquote>
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14PlaySelectedItemSuccess retAvrcp14PlaySelectedItemSuccess} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param scopeId The scope in which the UID of the media element item or folder item, if supported, is valid. Possible values are
	 *		<blockquote><b>AVRCP_SCOPE_ID_VFS</b>		(byte) 0x01
	 *		<br><b>AVRCP_SCOPE_ID_SEARCH</b>			(byte) 0x02
	 *		<br><b>AVRCP_SCOPE_ID_NOW_PLAYING</b>		(byte) 0x03</blockquote>
	 * @param uidCounter the value of uid counter we have.
	 * @param uid The UID of the media element item or folder item, if supported, to be played.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp14PlaySelectedItem(byte scopeId, int uidCounter, long uid) throws android.os.RemoteException;
/** 
	 * Request to perform the basic search from the current folder and all folders below the Browsed Players virtual filesystem. 
	 * Regular expressions shall not be supported. 
	 * <br>Search results are valid until
	 * 		<blockquote>Another search request is performed or
	 *		<br>A UIDs changed notification response is received
	 * 		<br>The Browsed player is changed</blockquote>
	 * <p>The search result would contain only media element items.
	 * <br>Searching may not be supported by all players. Furthermore, searching may only be possible on some players 
	 * when they are set as the Addressed Player.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14SearchResult retAvrcp14SearchResult} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param text The string to search on in the specified character set.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp14Search(java.lang.String text) throws android.os.RemoteException;
/** 
	 * Request A2DP/AVRCP connected remote device to add an item indicated by the UID to the NowPlaying queue. 
	 * <p>If a UID changed event has happened but not received by local yet, the previous UID counter may be sent. 
	 * In this case a failure status shall be returned.
	 * <p>Request this command with the scope parameter of 
	 *		<blockquote><b>AVRCP_SCOPE_ID_VFS</b>			(byte) 0x01
	 * 		<br><b>AVRCP_SCOPE_ID_SEARCH</b>				(byte) 0x02 or
	 * 		<br><b>AVRCP_SCOPE_ID_NOW_PLAYING</b>			(byte) 0x03</blockquote>
	 * shall result in the item being added to the NowPlaying folder on media players that support this command.
	 * <p>Never request this command with the scope parameter 
	 * 		<blockquote><b>AVRCP_SCOPE_ID_MEDIA_PLAYER</b>	(byte) 0x00.</blockquote>
	 * This command could be requested with the UID of a Folder Item if the folder is playable. 
	 * <p>The media items of that folder are added to the NowPlaying list, not the folder itself.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14AddToNowPlayingSuccess retAvrcp14AddToNowPlayingSuccess} and
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse}
	 * to be notified of subsequent result.
	 *
	 * @param scopeId The scope in which the UID of the media element item or folder item, if supported, is valid. Possible values are
	 *		<blockquote><b>AVRCP_SCOPE_ID_VFS</b>		(byte) 0x01
	 *		<br><b>AVRCP_SCOPE_ID_SEARCH</b>			(byte) 0x02
	 *		<br><b>AVRCP_SCOPE_ID_NOW_PLAYING</b>		(byte) 0x03</blockquote>
	 * @param uidCounter the value of uid counter we have.
	 * @param uid The UID of the media element item or folder item, if supported, to be played.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp14AddToNowPlaying(byte scopeId, int uidCounter, long uid) throws android.os.RemoteException;
/** 
	 * By the AVRCP v1.4 specification, this command is used to set an absolute volume to be used by the rendering device. 
	 * This is in addition to the relative volume commands. 
	 * <p>It is expected that the audio sink will perform as the TG role for this command.
	 * <br>As this command specifies a percentage rather than an absolute dB level, the CT should exercise caution when sending this command.
	 * <p>It should be noted that this command is intended to alter the rendering volume on the audio sink. 
	 * <br>It is not intended to alter the volume within the audio stream. The volume level which has actually been set on the TG is returned in the response. 
	 * This is to enable the CT to deal with whatever granularity of volume control the TG provides.
	 * <p>The setting volume is represented in one octet. The top bit (bit 7) is reserved for future definition. 
	 * <br>The volume is specified as a percentage of the maximum. The value 0x0 corresponds to 0%. The value 0x7F corresponds to 100%.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackAvrcp#retAvrcp14SetAbsoluteVolumeSuccess retAvrcp14SetAbsoluteVolumeSuccess} and 
	 * {@link UiCallbackAvrcp#onAvrcpErrorResponse onAvrcpErrorResponse} 
	 * to be notified of subsequent result.
	 *
	 * @param volume the setting volume value of octet from 0x00 to 0x7F.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqAvrcp14SetAbsoluteVolume(byte volume) throws android.os.RemoteException;
// Bluetooth
/** 
	 * Register callback functions for basic Settings functions.
	 * <br>Call this function to register callback functions for nFore service.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean registerBtCallback(com.nforetek.bt.aidl.UiCallbackBluetooth cb) throws android.os.RemoteException;
/** 
	 * Remove callback functions from nFore service.
     * <br>Call this function to remove previously registered callback interface for nFore Settings service.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean unregisterBtCallback(com.nforetek.bt.aidl.UiCallbackBluetooth cb) throws android.os.RemoteException;
/** 
	 * Get nFore bluetooth service version name.
	 *
	 * @return nFore Service version name.
	 */
public java.lang.String getNfServiceVersionName() throws android.os.RemoteException;
/** 
	 * Set local Bluetooth adapter to enable or disable .
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackBluetooth#onAdapterStateChanged onAdapterStateChanged}
	 * to be notified of subsequent adapter state changes.
	 *
	 * @param enable true to enable Bluetooth adapter or false to disable.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean setBtEnable(boolean enable) throws android.os.RemoteException;
/** 
	 * Set local Bluetooth adapter discoverable for specific duration in seconds.
	 * <br>The system default duration for discoverable might differentiate from each other in different platforms.
	 * However, it is 120 seconds in default.
	 * <br>If the duration is negative value, discoverable would be disabled.	 
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackBluetooth#onAdapterDiscoverableModeChanged onAdapterDiscoverableModeChanged}
	 * to be notified of subsequent adapter state changes.
	 * The outcomes of this setting will be:
	 * <blockquote><p><b>enabled</b> with timeout, 
	 * <br><b>disabled</b> timeout = -1
	 * <br><b>DEFAULT_DISCOVERABLE_TIMEOUT</b> timeout = null</blockquote>
	 * The <b>DEFAULT_DISCOVERABLE_TIMEOUT</b> is 120s and the maximum timeout is 300s.
	 *
	 * @param timeout the duration of discoverable in seconds
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean setBtDiscoverableTimeout(int timeout) throws android.os.RemoteException;
/** 
	 * Start scan process for remote devices.
	 * <br>Client should not request to start scanning twice or more in 12 seconds.
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackBluetooth#onAdapterDiscoveryStarted onAdapterDiscoveryStarted}, {@link UiCallbackBluetooth#onDeviceFound onDeviceFound}
	 * and {@link UiCallbackBluetooth#onAdapterDiscoveryFinished onAdapterDiscoveryFinished}
	 * to be notified of subsequent adapter state changes.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean startBtDiscovery() throws android.os.RemoteException;
/** 
	 * Stop scanning process for remote devices.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackBluetooth#onAdapterDiscoveryFinished onAdapterDiscoveryFinished}
	 * to be notified of subsequent adapter state changes.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean cancelBtDiscovery() throws android.os.RemoteException;
/** 
	 * Request to pair with given Bluetooth hardware address.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackBluetooth#onDeviceBondStateChanged onDeviceBondStateChanged} and {@link UiCallbackBluetooth#onDeviceUuidsUpdated onDeviceUuidsUpdated}
	 * to be notified if pairing is successful.
	 *
	 * @attention The Android system only supports 7 paired devices maximal. System would delete the first paired device automatically when
	 * the limit is reached. 
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqBtPair(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request to unpair with given Bluetooth hardware address.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackBluetooth#onDeviceBondStateChanged onDeviceBondStateChanged}
	 * to be notified if unpairing is successful.
	 * However, this operation only removes pairing record locally. Remote device would not be notified until pairing again.
	 * All connected or connecting profiles should be terminated before unpairing.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqBtUnpair(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request to get the paired device list.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackBluetooth#retPairedDevices retPairedDevices}
	 * to be notified of subsequent result.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqBtPairedDevices() throws android.os.RemoteException;
/** 
	 * Get the name of local Bluetooth adapter.
	 * <br>If there is an error, the string "UNKNOWN" would be returned.
	 *
	 * @return the String type name of local Bluetooth adapter.
	 */
public java.lang.String getBtLocalName() throws android.os.RemoteException;
/** 
	 * Request the name of remote Bluetooth device with given address.
	 * <br>This method would return the name announced by remote device in String type only if this remote device
	 * has been scanned before. Otherwise the empty string would be returned.
	 *	 	 
	 * @param address valid Bluetooth MAC address.	 
	 * @return the real String type name of remote device or the empty string.
	 */
public java.lang.String getBtRemoteDeviceName(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Get the address of local Bluetooth adapter.
	 *
	 * @return the String type address of local Bluetooth adapter.
	 */
public java.lang.String getBtLocalAddress() throws android.os.RemoteException;
/** 
	 * Set the name of local Bluetooth adapter.
	 *
	 * @param name the name to set.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean setBtLocalName(java.lang.String name) throws android.os.RemoteException;
/**
	 * Check if Bluetooth is currently enabled.
	 *
	 * @return true if the local adapter is turned on.
	 */
public boolean isBtEnabled() throws android.os.RemoteException;
/** 
	 * Get the current state of local Bluetooth adapter.
	 *
	 * @return int value to denote the current state. Possible values are:
	 *		<p><blockquote><b>ERROR</b>			(int) -1
	 *		<br><b>BT_STATE_OFF</b>				(int) 300
	 *		<br><b>BT_STATE_TURNING_ON</b>		(int) 301
	 *		<br><b>BT_STATE_ON</b>				(int) 302
	 *		<br><b>BT_STATE_TURNING_OFF</b>		(int) 303</blockquote>	
	 */
public int getBtState() throws android.os.RemoteException;
/** 
	 * Check if Bluetooth is currently scanning remote devices.
	 *
	 * @return true if scanning.
	 */
public boolean isBtDiscovering() throws android.os.RemoteException;
/** 
	 * Check if Bluetooth is currently discoverable from remote devices.
	 *
	 * @return true if discoverable.
	 */
public boolean isBtDiscoverable() throws android.os.RemoteException;
/** 
	 * Set auto connect mode as enabled or disabled.
	 * <br>Auto-connect only applies to HSP, HFP, A2DP and AVRCP services when out of range and ACC on/off events take place.
	 * Besides, only one of HSP or HFP would be re-connected, and HFP is preferred to HSP.
	 * <br>Auto-connect only applies to the following conditions: 
	 *		<blockquote><p>there is an out of range event, or 	
	 *		<br>there is a connected phone before ACC off and then ACC on </blockquote>
	 *
	 * @param enable true to enable or false to disable.
	 */
public void setBtAutoConnectMode(boolean enable) throws android.os.RemoteException;
/** 
	 * Check if auto-connect is currently enabled.
	 *
	 * @return true if auto-connect is enabled.
	 */
public boolean isBtAutoConnectEnable() throws android.os.RemoteException;
/** 
	 * Request to connect HSP, HFP, A2DP, and AVRCP to remote device.
	 * <br>If remote device supports both HSP and HFP, nFore service connects HFP instead of HSP.
	 * <br>This is an asynchronous call: it will return immediately with int returned value, 
	 * which denotes the profiles nFore service plans to connect to, and 
	 * clients should register and implement callback functions
	 * {@link UiCallbackHsp#onHspStateChanged onHspStateChanged}, 
	 * {@link UiCallbackHfp#onHfpStateChanged onHfpStateChanged}, 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged}, and
	 * {@link UiCallbackAvrcp#onAvrcpStateChanged onAvrcpStateChanged}  
	 * to be notified of subsequent profile state changes.
	 * 
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return int value to denote the profiles planned to connect. Possible values are:
	 *		<blockquote><b>ERROR</b>	(int) -1
	 *		<br><b>PROFILE_HSP</b>		(int) 1
	 *		<br><b>PROFILE_HFP</b>		(int) (1 << 1)
	 *		<br><b>PROFILE_A2DP</b>		(int) (1 << 2)</blockquote>	 
	 * For example, value 6 (0000 0110) means that HFP and A2DP would be connected.	 	 
	 */
public int reqBtConnectHfpA2dp(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request to disconnect all connected profiles.
	 * <br>This is an asynchronous call: it will return immediately with int returned value, 
	 * which denotes the profiles nFore service plans to disconnect to, and 
	 * clients should register and implement callback functions
	 * {@link UiCallbackHsp#onHspStateChanged onHspStateChanged}, 
	 * {@link UiCallbackHfp#onHfpStateChanged onHfpStateChanged}, 
	 * {@link UiCallbackA2dp#onA2dpStateChanged onA2dpStateChanged}, and
	 * {@link UiCallbackAvrcp#onAvrcpStateChanged onAvrcpStateChanged}  
	 * to be notified of subsequent profile state changes.
	 * 
	 * <br>If there is no connection currently, this request would return ERROR.
	 *
	 * @return int value to denote the profiles planned to disconnect. Possible values are:
	 *		<p><blockquote><b>ERROR</b>		(int) -1
	 *		<br><b>PROFILE_HSP</b>			(int) 1
	 *		<br><b>PROFILE_HFP</b>			(int) (1 << 1)
	 *		<br><b>PROFILE_A2DP</b>			(int) (1 << 2)
	 * 		<br><b>PROFILE_SPP</b>			(int) (1 << 3)
	 * 		<br><b>PROFILE_PBAP</b>			(int) (1 << 4)
	 *		<br><b>PROFILE_AVRCP</b>		(int) (1 << 5)
	 *		<br><b>PROFILE_FTP</b>			(int) (1 << 6)
	 *		<br><b>PROFILE_MAP</b>			(int) (1 << 7)
	 *		<br><b>PROFILE_AVRCP_13</b>		(int) (1 << 8)
	 *		<br><b>PROFILE_AVRCP_14</b>		(int) (1 << 9)
	 *		<br><b>PROFILE_PANU</b>			(int) (1 << 10)	
	 *		<br><b>PROFILE_NAP</b>			(int) (1 << 11)
	 *		<br><b>PROFILE_DUN</b>			(int) (1 << 12)</blockquote>	  
	 * For example, value 6 (0000 0110) means that HFP and A2DP would be disconnected.	 	 
	 */
public int reqBtDisconnectAll() throws android.os.RemoteException;
/** 
	 * Get the supported profiles of remote device.
	 * The requested address must be the paired device.
	 *
	 * This command will return with an integer value immediately, which represents the supported profiles.
	 * If 0x00 is returned, that means UUID fetched from system framework is null and nFore service will request
	 * SDP query to this device automatically. Clients should register and implement callback functions
	 * {@link IServiceCallback#onDeviceUuidsGot onDeviceUuidsGot} 
	 * to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address of paired device.
	 * @return the supported profiles of paired device in int type. Possible values are:
	 *		<p><blockquote><b>ERROR</b>		(int) -1
	 *		<br><b>PROFILE_HSP</b>			(int) 1
	 *		<br><b>PROFILE_HFP</b>			(int) (1 << 1)
	 *		<br><b>PROFILE_A2DP</b>			(int) (1 << 2)
	 * 		<br><b>PROFILE_SPP</b>			(int) (1 << 3)
	 * 		<br><b>PROFILE_PBAP</b>			(int) (1 << 4)
	 *		<br><b>PROFILE_AVRCP</b>		(int) (1 << 5)
	 *		<br><b>PROFILE_FTP</b>			(int) (1 << 6)
	 *		<br><b>PROFILE_MAP</b>			(int) (1 << 7)
	 *		<br><b>PROFILE_AVRCP_13</b>		(int) (1 << 8)
	 *		<br><b>PROFILE_AVRCP_14</b>		(int) (1 << 9)
	 *		<br><b>PROFILE_PANU</b>			(int) (1 << 10)
	 *		<br><b>PROFILE_NAP</b>			(int) (1 << 11)
	 *		<br><b>PROFILE_DUN</b>			(int) (1 << 12)
	 *		<br><b>PROFILE_IAP</b>			(int) (1 << 13)</blockquote>
	 * For example, value 7 (0000 0111) means it supports HSP, HFP and A2DP.
	 */
public int getBtRemoteUuids(java.lang.String address) throws android.os.RemoteException;
/**
	 * Switch Bluetooth mode to other role.
	 *
	 * @param mode the mode of Bluetooth role in integer type
	 * 		<p><blockquote><b>MODE_CAR</b>		(int) 1
	 *		<br><b>MODE_TABLET</b>				(int) 2
	 */
public boolean switchBtRoleMode(int mode) throws android.os.RemoteException;
/**
	 * Get Bluetooth role mode in integer.
	 *
	 * @return The mode of Bluetooth role in integer type
	 * 		<p><blockquote><b>MODE_CAR</b>		(int) 1
	 *		<br><b>MODE_TABLET</b>				(int) 2
	 */
public int getBtRoleMode() throws android.os.RemoteException;
// HFP
/** 
	 * Register callback functions for HFP.
	 * <br>Call this function to register callback functions for HFP.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean registerHfpCallback(com.nforetek.bt.aidl.UiCallbackHfp cb) throws android.os.RemoteException;
/** 
	 * Remove callback functions from HFP.
     * <br>Call this function to remove previously registered callback interface for HFP.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean unregisterHfpCallback(com.nforetek.bt.aidl.UiCallbackHfp cb) throws android.os.RemoteException;
/** 
	 * Get current connection state of the remote device.
	 * 
	 * @return current state of HFP profile service.
	 */
public int getHfpConnectionState() throws android.os.RemoteException;
/** 
	 * Check if local device is HFP connected with remote device.
	 *
	 * @return true to indicate HFP is connected, or false disconnected.
	 */
public boolean isHfpConnected() throws android.os.RemoteException;
/** 
	 * Get the Bluetooth hardware address of HFP connected remote device.
	 *
	 * @return Bluetooth hardware address as string if there is a connected HFP device, or 
	 * <code>DEFAULT_ADDRESS</code> 00:00:00:00:00:00.
	 */
public java.lang.String getHfpConnectedAddress() throws android.os.RemoteException;
/** 
	 * Get the current audio state of HFP connected remote device.
	 * 
	 * @return current HFP audio state.
	 */
public int getHfpAudioConnectionState() throws android.os.RemoteException;
/** 
	 * Request to connect HFP to the remote device.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackHfp#onHfpStateChanged onHfpStateChanged} to be notified of subsequent profile state changes.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqHfpConnect(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request to disconnect HFP to the remote device.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function 
	 * {@link UiCallbackHfp#onHfpStateChanged onHfpStateChanged} to be notified of subsequent profile state changes.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqHfpDisconnect(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Get the signal strength of HFP connected remote device.
	 *	 	 
	 * @return the current signal strength of remote device.	 
	 */
public int getHfpRemoteSignalStrength() throws android.os.RemoteException;
/** 
	 * Get the active phone number information of HFP connected remote device.
	 *	 	 
	 * @return the phone number information list of remote device.	 
	 */
public java.util.List<com.nforetek.bt.aidl.NfHfpClientCall> getHfpCallList() throws android.os.RemoteException;
/** 
	 * Check if the HFP connected remote device is on roaming.
	 *	 	 
	 * @return true to indicate the remote device is current on roaming.	 
	 */
public boolean isHfpRemoteOnRoaming() throws android.os.RemoteException;
/** 
	 * Get the battery indicator of HFP connected remote device.
	 *
	 * @return the current battery indicator of remote device.
	 */
public int getHfpRemoteBatteryIndicator() throws android.os.RemoteException;
/** 
	 * Check if the HFP connected remote device has telecom service.
	 *	 	 
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate remote device has telecom service.
	 */
public boolean isHfpRemoteTelecomServiceOn() throws android.os.RemoteException;
/** 
	 * Check if the voice dial of HFP connected remote device is activated.
	 *
	 * @param address valid Bluetooth MAC address of connected device.	 
	 * @return true to indicate voice dial is activated for remote device.
	 */
public boolean isHfpRemoteVoiceDialOn() throws android.os.RemoteException;
/** 
	 * Request HFP connected remote device to dial a call with given phone number.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 *
	 * @param number the outgoing call phone number.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqHfpDialCall(java.lang.String number) throws android.os.RemoteException;
/** 
	 * Request HFP connected remote device to re-dial the last outgoing call.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqHfpReDial() throws android.os.RemoteException;
/** 
	 * Request HFP connected remote device to do memory dialing.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 *
 	 * @param index the memory index on mobile phone. The phone number with the memory index will be dialed out, for example: 1-9
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqHfpMemoryDial(java.lang.String index) throws android.os.RemoteException;
/** 
	 * Request HFP connected remote device to answer the incoming call.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true if the command is sent successfully
	 */
public boolean reqHfpAnswerCall(int flag) throws android.os.RemoteException;
/** 
	 * Request HFP connected remote device to reject the incoming call.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true if the command is sent successfully
	 */
public boolean reqHfpRejectIncomingCall() throws android.os.RemoteException;
/** 
	 * Request HFP connected remote device to terminate the ongoing call.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link INfCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 *
	 * @return true if the command is sent successfully
	 */
public boolean reqHfpTerminateCurrentCall() throws android.os.RemoteException;
/** 
	 * Request HFP connected remote device to send the DTMF.
	 * <p>Due to the compatibility, please request this API with single DTMF number each time.
	 * <p>Avoid requesting with serial DTMF numbers. 
	 *
 	 * @param number DTMF number.
 	 * @return true if the command is sent successfully
	 */
public boolean reqHfpSendDtmf(java.lang.String number) throws android.os.RemoteException;
/** 
	 * Request HFP connected remote device to transfer the audio to Carkit.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged} to be notified of subsequent state changes.
	 *
	 * @return true if the command is sent successfully	 
	 */
public boolean reqHfpAudioTransferToCarkit() throws android.os.RemoteException;
/** 
	 * Request HFP connected remote device to transfer the audio to Phone.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged} to be notified of subsequent state changes.
	 *
	 * @return true if the command is sent successfully	 
	 */
public boolean reqHfpAudioTransferToPhone() throws android.os.RemoteException;
/** 
	 * Get the network operator of HFP connected remote device.
	 *	 	 
	 * @return network operator
	 */
public java.lang.String getHfpRemoteNetworkOperator() throws android.os.RemoteException;
/** 
	 * Get the subscriber number of HFP connected remote device.
	 *	 	 
	 * @return subscriber number
	 */
public java.lang.String getHfpRemoteSubscriberNumber() throws android.os.RemoteException;
/**
	 * Request HFP connected remote device to do the voice dialing.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link UiCallbackHfp#onHfpCallChanged onHfpCallChanged} and {@link UiCallbackHfp#onHfpAudioStateChanged onHfpAudioStateChanged}
	 * to be notified of subsequent profile state changes.
	 * 
 	 * @param enable true to start the voice dialing.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqHfpVoiceDial(boolean enable) throws android.os.RemoteException;
/**
	 * Stop sending HFP stream data to audio track.
	 */
public void pauseHfpRender() throws android.os.RemoteException;
/**
	 * Start sending HFP stream data to audio track.
	 */
public void startHfpRender() throws android.os.RemoteException;
/**
	 * Check if mic is mute.
	 */
public boolean isHfpMicMute() throws android.os.RemoteException;
/**
	 * Request HFP Mute Mic during call
	 * @param mute true to mute the microphone
	 */
public void muteHfpMic(boolean mute) throws android.os.RemoteException;
public boolean isHfpInBandRingtoneSupport() throws android.os.RemoteException;
// PBAP
/** 
	 * Register callback functions for PBAP.
	 * <br>Call this function to register callback functions for PBAP.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean registerPbapCallback(com.nforetek.bt.aidl.UiCallbackPbap cb) throws android.os.RemoteException;
/** 
	 * Remove callback functions from PBAP.
     * <br>Call this function to remove previously registered callback interface for PBAP.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean unregisterPbapCallback(com.nforetek.bt.aidl.UiCallbackPbap cb) throws android.os.RemoteException;
/** 
	 * Get current connection state of the remote device.
	 *
	 * @return current state of PBAP profile service.
	 */
public int getPbapConnectionState() throws android.os.RemoteException;
/** 
	 * Check if local device is downloading phonebook from remote device.
	 *
	 * @return true to indicate PBAP is downloading, or false disconnected.
	 */
public boolean isPbapDownloading() throws android.os.RemoteException;
/** 
	 * Get the Bluetooth hardware address of PBAP downloading remote device.
	 *
	 * @return Bluetooth hardware address as string if there is a downloading PBAP device, 
	 * or otherwise <code>DEFAULT_ADDRESS</code> 00:00:00:00:00:00.
	 */
public java.lang.String getPbapDownloadingAddress() throws android.os.RemoteException;
/**
	 * Request to download phonebook with vCard from remote device and by pass callback to user.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackPbap#retPbapDownloadedContact retPbapDownloadedContact} 
	 * and {@link INfCallbackPbap#retPbapDownloadedCallLog retPbapDownloadedCallLog}
	 * and {@link INfCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6
	 *		<br><b>PBAP_STORAGE_SPEEDDIAL</b>			(int) 7
	 *		<br><b>PBAP_STORAGE_FAVORITE</b>			(int) 8</blockquote>
	 * @param property download property mask. Possible storage type are:
	 *		<blockquote><b>PBAP_PROPERTY_MASK_VERSION</b>	(int) (1&lt;&lt;0)
	 *		<br><b>PBAP_PROPERTY_MASK_FN</b>		(int) (1&lt;&lt;1)
	 *		<br><b>PBAP_PROPERTY_MASK_N</b>			(int) (1&lt;&lt;2)
	 *		<br><b>PBAP_PROPERTY_MASK_PHOTO</b>		(int) (1&lt;&lt;3)
	 *		<br><b>PBAP_PROPERTY_MASK_BDAY</b>		(int) (1&lt;&lt;4)
	 *		<br><b>PBAP_PROPERTY_MASK_ADR</b>		(int) (1&lt;&lt;5)
	 *		<br><b>PBAP_PROPERTY_MASK_LABEL</b>		(int) (1&lt;&lt;6)
	 *		<br><b>PBAP_PROPERTY_MASK_TEL</b>		(int) (1&lt;&lt;7)
	 *		<br><b>PBAP_PROPERTY_MASK_EMAIL</b>		(int) (1&lt;&lt;8)
	 *		<br><b>PBAP_PROPERTY_MASK_MAILER</b>	(int) (1&lt;&lt;9)
	 *		<br><b>PBAP_PROPERTY_MASK_TZ</b>		(int) (1&lt;&lt;10)
	 *		<br><b>PBAP_PROPERTY_MASK_GEO</b>		(int) (1&lt;&lt;11)
	 *		<br><b>PBAP_PROPERTY_MASK_TITLE</b>		(int) (1&lt;&lt;12)
	 *		<br><b>PBAP_PROPERTY_MASK_ROLE</b>		(int) (1&lt;&lt;13)
	 *		<br><b>PBAP_PROPERTY_MASK_LOGO</b>		(int) (1&lt;&lt;14)
	 *		<br><b>PBAP_PROPERTY_MASK_AGENT</b>		(int) (1&lt;&lt;15)
	 *		<br><b>PBAP_PROPERTY_MASK_ORG</b>		(int) (1&lt;&lt;16)
	 *		<br><b>PBAP_PROPERTY_MASK_NOTE</b>		(int) (1&lt;&lt;17)
	 *		<br><b>PBAP_PROPERTY_MASK_REV</b>		(int) (1&lt;&lt;18)
	 *		<br><b>PBAP_PROPERTY_MASK_SOUND</b>		(int) (1&lt;&lt;19)
	 *		<br><b>PBAP_PROPERTY_MASK_URL</b>		(int) (1&lt;&lt;20)
	 *		<br><b>PBAP_PROPERTY_MASK_UID</b>		(int) (1&lt;&lt;21)
	 *		<br><b>PBAP_PROPERTY_MASK_KEY</b>		(int) (1&lt;&lt;22)
	 *		<br><b>PBAP_PROPERTY_MASK_NICKNAME</b>	(int) (1&lt;&lt;23)
	 *		<br><b>PBAP_PROPERTY_MASK_CATEGORIES</b>(int) (1&lt;&lt;24)
	 *		<br><b>PBAP_PROPERTY_MASK_PROID</b>		(int) (1&lt;&lt;25)
	 *		<br><b>PBAP_PROPERTY_MASK_CLASS</b>		(int) (1&lt;&lt;26)
	 *		<br><b>PBAP_PROPERTY_MASK_SORT_STRING</b>(int) (1&lt;&lt;27)
	 *		<br><b>PBAP_PROPERTY_MASK_TIME_STAMP</b>(int) (1&lt;&lt;28)</blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqPbapDownload(java.lang.String address, int storage, int property) throws android.os.RemoteException;
/**
	 * Request to download phonebook with vCard from remote device and by pass callback to user.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackPbap#retPbapDownloadedContact retPbapDownloadedContact} 
	 * and {@link INfCallbackPbap#retPbapDownloadedCallLog retPbapDownloadedCallLog}
	 * and {@link INfCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6
	 *		<br><b>PBAP_STORAGE_SPEEDDIAL</b>			(int) 7
	 *		<br><b>PBAP_STORAGE_FAVORITE</b>			(int) 8</blockquote>
	 * @param property download property mask. Possible storage type are:
	 *		<blockquote><b>PBAP_PROPERTY_MASK_VERSION</b>	(int) (1&lt;&lt;0)
	 *		<br><b>PBAP_PROPERTY_MASK_FN</b>		(int) (1&lt;&lt;1)
	 *		<br><b>PBAP_PROPERTY_MASK_N</b>			(int) (1&lt;&lt;2)
	 *		<br><b>PBAP_PROPERTY_MASK_PHOTO</b>		(int) (1&lt;&lt;3)
	 *		<br><b>PBAP_PROPERTY_MASK_BDAY</b>		(int) (1&lt;&lt;4)
	 *		<br><b>PBAP_PROPERTY_MASK_ADR</b>		(int) (1&lt;&lt;5)
	 *		<br><b>PBAP_PROPERTY_MASK_LABEL</b>		(int) (1&lt;&lt;6)
	 *		<br><b>PBAP_PROPERTY_MASK_TEL</b>		(int) (1&lt;&lt;7)
	 *		<br><b>PBAP_PROPERTY_MASK_EMAIL</b>		(int) (1&lt;&lt;8)
	 *		<br><b>PBAP_PROPERTY_MASK_MAILER</b>	(int) (1&lt;&lt;9)
	 *		<br><b>PBAP_PROPERTY_MASK_TZ</b>		(int) (1&lt;&lt;10)
	 *		<br><b>PBAP_PROPERTY_MASK_GEO</b>		(int) (1&lt;&lt;11)
	 *		<br><b>PBAP_PROPERTY_MASK_TITLE</b>		(int) (1&lt;&lt;12)
	 *		<br><b>PBAP_PROPERTY_MASK_ROLE</b>		(int) (1&lt;&lt;13)
	 *		<br><b>PBAP_PROPERTY_MASK_LOGO</b>		(int) (1&lt;&lt;14)
	 *		<br><b>PBAP_PROPERTY_MASK_AGENT</b>		(int) (1&lt;&lt;15)
	 *		<br><b>PBAP_PROPERTY_MASK_ORG</b>		(int) (1&lt;&lt;16)
	 *		<br><b>PBAP_PROPERTY_MASK_NOTE</b>		(int) (1&lt;&lt;17)
	 *		<br><b>PBAP_PROPERTY_MASK_REV</b>		(int) (1&lt;&lt;18)
	 *		<br><b>PBAP_PROPERTY_MASK_SOUND</b>		(int) (1&lt;&lt;19)
	 *		<br><b>PBAP_PROPERTY_MASK_URL</b>		(int) (1&lt;&lt;20)
	 *		<br><b>PBAP_PROPERTY_MASK_UID</b>		(int) (1&lt;&lt;21)
	 *		<br><b>PBAP_PROPERTY_MASK_KEY</b>		(int) (1&lt;&lt;22)
	 *		<br><b>PBAP_PROPERTY_MASK_NICKNAME</b>	(int) (1&lt;&lt;23)
	 *		<br><b>PBAP_PROPERTY_MASK_CATEGORIES</b>(int) (1&lt;&lt;24)
	 *		<br><b>PBAP_PROPERTY_MASK_PROID</b>		(int) (1&lt;&lt;25)
	 *		<br><b>PBAP_PROPERTY_MASK_CLASS</b>		(int) (1&lt;&lt;26)
	 *		<br><b>PBAP_PROPERTY_MASK_SORT_STRING</b>(int) (1&lt;&lt;27)
	 *		<br><b>PBAP_PROPERTY_MASK_TIME_STAMP</b>(int) (1&lt;&lt;28)</blockquote>
	 * @param startPos download start position.
	 * @param offset download offset.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqPbapDownloadRange(java.lang.String address, int storage, int property, int startPos, int offset) throws android.os.RemoteException;
/**
	 * Request to download phonebook with vCard from remote device and save to local database.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6
	 *		<br><b>PBAP_STORAGE_SPEEDDIAL</b>			(int) 7
	 *		<br><b>PBAP_STORAGE_FAVORITE</b>			(int) 8</blockquote>	
	 * @param property download property mask. Possible storage type are:
	 *		<blockquote><b>PBAP_PROPERTY_MASK_VERSION</b>	(int) (1&lt;&lt;0)
	 *		<br><b>PBAP_PROPERTY_MASK_FN</b>		(int) (1&lt;&lt;1)
	 *		<br><b>PBAP_PROPERTY_MASK_N</b>			(int) (1&lt;&lt;2)
	 *		<br><b>PBAP_PROPERTY_MASK_PHOTO</b>		(int) (1&lt;&lt;3)
	 *		<br><b>PBAP_PROPERTY_MASK_BDAY</b>		(int) (1&lt;&lt;4)
	 *		<br><b>PBAP_PROPERTY_MASK_ADR</b>		(int) (1&lt;&lt;5)
	 *		<br><b>PBAP_PROPERTY_MASK_LABEL</b>		(int) (1&lt;&lt;6)
	 *		<br><b>PBAP_PROPERTY_MASK_TEL</b>		(int) (1&lt;&lt;7)
	 *		<br><b>PBAP_PROPERTY_MASK_EMAIL</b>		(int) (1&lt;&lt;8)
	 *		<br><b>PBAP_PROPERTY_MASK_MAILER</b>	(int) (1&lt;&lt;9)
	 *		<br><b>PBAP_PROPERTY_MASK_TZ</b>		(int) (1&lt;&lt;10)
	 *		<br><b>PBAP_PROPERTY_MASK_GEO</b>		(int) (1&lt;&lt;11)
	 *		<br><b>PBAP_PROPERTY_MASK_TITLE</b>		(int) (1&lt;&lt;12)
	 *		<br><b>PBAP_PROPERTY_MASK_ROLE</b>		(int) (1&lt;&lt;13)
	 *		<br><b>PBAP_PROPERTY_MASK_LOGO</b>		(int) (1&lt;&lt;14)
	 *		<br><b>PBAP_PROPERTY_MASK_AGENT</b>		(int) (1&lt;&lt;15)
	 *		<br><b>PBAP_PROPERTY_MASK_ORG</b>		(int) (1&lt;&lt;16)
	 *		<br><b>PBAP_PROPERTY_MASK_NOTE</b>		(int) (1&lt;&lt;17)
	 *		<br><b>PBAP_PROPERTY_MASK_REV</b>		(int) (1&lt;&lt;18)
	 *		<br><b>PBAP_PROPERTY_MASK_SOUND</b>		(int) (1&lt;&lt;19)
	 *		<br><b>PBAP_PROPERTY_MASK_URL</b>		(int) (1&lt;&lt;20)
	 *		<br><b>PBAP_PROPERTY_MASK_UID</b>		(int) (1&lt;&lt;21)
	 *		<br><b>PBAP_PROPERTY_MASK_KEY</b>		(int) (1&lt;&lt;22)
	 *		<br><b>PBAP_PROPERTY_MASK_NICKNAME</b>	(int) (1&lt;&lt;23)
	 *		<br><b>PBAP_PROPERTY_MASK_CATEGORIES</b>(int) (1&lt;&lt;24)
	 *		<br><b>PBAP_PROPERTY_MASK_PROID</b>		(int) (1&lt;&lt;25)
	 *		<br><b>PBAP_PROPERTY_MASK_CLASS</b>		(int) (1&lt;&lt;26)
	 *		<br><b>PBAP_PROPERTY_MASK_SORT_STRING</b>(int) (1&lt;&lt;27)
	 *		<br><b>PBAP_PROPERTY_MASK_TIME_STAMP</b>(int) (1&lt;&lt;28)</blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqPbapDownloadToDatabase(java.lang.String address, int storage, int property) throws android.os.RemoteException;
/**
	 * Request to download phonebook with vCard from remote device and save to local Contacts Provider.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6
	 *		<br><b>PBAP_STORAGE_SPEEDDIAL</b>			(int) 7
	 *		<br><b>PBAP_STORAGE_FAVORITE</b>			(int) 8</blockquote>
	 * @param property download property mask. Possible storage type are:
	 *		<blockquote><b>PBAP_PROPERTY_MASK_VERSION</b>	(int) (1&lt;&lt;0)
	 *		<br><b>PBAP_PROPERTY_MASK_FN</b>		(int) (1&lt;&lt;1)
	 *		<br><b>PBAP_PROPERTY_MASK_N</b>			(int) (1&lt;&lt;2)
	 *		<br><b>PBAP_PROPERTY_MASK_PHOTO</b>		(int) (1&lt;&lt;3)
	 *		<br><b>PBAP_PROPERTY_MASK_BDAY</b>		(int) (1&lt;&lt;4)
	 *		<br><b>PBAP_PROPERTY_MASK_ADR</b>		(int) (1&lt;&lt;5)
	 *		<br><b>PBAP_PROPERTY_MASK_LABEL</b>		(int) (1&lt;&lt;6)
	 *		<br><b>PBAP_PROPERTY_MASK_TEL</b>		(int) (1&lt;&lt;7)
	 *		<br><b>PBAP_PROPERTY_MASK_EMAIL</b>		(int) (1&lt;&lt;8)
	 *		<br><b>PBAP_PROPERTY_MASK_MAILER</b>	(int) (1&lt;&lt;9)
	 *		<br><b>PBAP_PROPERTY_MASK_TZ</b>		(int) (1&lt;&lt;10)
	 *		<br><b>PBAP_PROPERTY_MASK_GEO</b>		(int) (1&lt;&lt;11)
	 *		<br><b>PBAP_PROPERTY_MASK_TITLE</b>		(int) (1&lt;&lt;12)
	 *		<br><b>PBAP_PROPERTY_MASK_ROLE</b>		(int) (1&lt;&lt;13)
	 *		<br><b>PBAP_PROPERTY_MASK_LOGO</b>		(int) (1&lt;&lt;14)
	 *		<br><b>PBAP_PROPERTY_MASK_AGENT</b>		(int) (1&lt;&lt;15)
	 *		<br><b>PBAP_PROPERTY_MASK_ORG</b>		(int) (1&lt;&lt;16)
	 *		<br><b>PBAP_PROPERTY_MASK_NOTE</b>		(int) (1&lt;&lt;17)
	 *		<br><b>PBAP_PROPERTY_MASK_REV</b>		(int) (1&lt;&lt;18)
	 *		<br><b>PBAP_PROPERTY_MASK_SOUND</b>		(int) (1&lt;&lt;19)
	 *		<br><b>PBAP_PROPERTY_MASK_URL</b>		(int) (1&lt;&lt;20)
	 *		<br><b>PBAP_PROPERTY_MASK_UID</b>		(int) (1&lt;&lt;21)
	 *		<br><b>PBAP_PROPERTY_MASK_KEY</b>		(int) (1&lt;&lt;22)
	 *		<br><b>PBAP_PROPERTY_MASK_NICKNAME</b>	(int) (1&lt;&lt;23)
	 *		<br><b>PBAP_PROPERTY_MASK_CATEGORIES</b>(int) (1&lt;&lt;24)
	 *		<br><b>PBAP_PROPERTY_MASK_PROID</b>		(int) (1&lt;&lt;25)
	 *		<br><b>PBAP_PROPERTY_MASK_CLASS</b>		(int) (1&lt;&lt;26)
	 *		<br><b>PBAP_PROPERTY_MASK_SORT_STRING</b>(int) (1&lt;&lt;27)
	 *		<br><b>PBAP_PROPERTY_MASK_TIME_STAMP</b>(int) (1&lt;&lt;28)</blockquote>
	 * @param startPos download start position.
	 * @param offset download offset.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqPbapDownloadRangeToDatabase(java.lang.String address, int storage, int property, int startPos, int offset) throws android.os.RemoteException;
/**
	 * Request to download phonebook with vCard from remote device and save to local Contacts Provider.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6
	 *		<br><b>PBAP_STORAGE_SPEEDDIAL</b>			(int) 7
	 *		<br><b>PBAP_STORAGE_FAVORITE</b>			(int) 8</blockquote>
	 * @param property download property mask. Possible storage type are:
	 *		<blockquote><b>PBAP_PROPERTY_MASK_VERSION</b>	(int) (1&lt;&lt;0)
	 *		<br><b>PBAP_PROPERTY_MASK_FN</b>		(int) (1&lt;&lt;1)
	 *		<br><b>PBAP_PROPERTY_MASK_N</b>			(int) (1&lt;&lt;2)
	 *		<br><b>PBAP_PROPERTY_MASK_PHOTO</b>		(int) (1&lt;&lt;3)
	 *		<br><b>PBAP_PROPERTY_MASK_BDAY</b>		(int) (1&lt;&lt;4)
	 *		<br><b>PBAP_PROPERTY_MASK_ADR</b>		(int) (1&lt;&lt;5)
	 *		<br><b>PBAP_PROPERTY_MASK_LABEL</b>		(int) (1&lt;&lt;6)
	 *		<br><b>PBAP_PROPERTY_MASK_TEL</b>		(int) (1&lt;&lt;7)
	 *		<br><b>PBAP_PROPERTY_MASK_EMAIL</b>		(int) (1&lt;&lt;8)
	 *		<br><b>PBAP_PROPERTY_MASK_MAILER</b>	(int) (1&lt;&lt;9)
	 *		<br><b>PBAP_PROPERTY_MASK_TZ</b>		(int) (1&lt;&lt;10)
	 *		<br><b>PBAP_PROPERTY_MASK_GEO</b>		(int) (1&lt;&lt;11)
	 *		<br><b>PBAP_PROPERTY_MASK_TITLE</b>		(int) (1&lt;&lt;12)
	 *		<br><b>PBAP_PROPERTY_MASK_ROLE</b>		(int) (1&lt;&lt;13)
	 *		<br><b>PBAP_PROPERTY_MASK_LOGO</b>		(int) (1&lt;&lt;14)
	 *		<br><b>PBAP_PROPERTY_MASK_AGENT</b>		(int) (1&lt;&lt;15)
	 *		<br><b>PBAP_PROPERTY_MASK_ORG</b>		(int) (1&lt;&lt;16)
	 *		<br><b>PBAP_PROPERTY_MASK_NOTE</b>		(int) (1&lt;&lt;17)
	 *		<br><b>PBAP_PROPERTY_MASK_REV</b>		(int) (1&lt;&lt;18)
	 *		<br><b>PBAP_PROPERTY_MASK_SOUND</b>		(int) (1&lt;&lt;19)
	 *		<br><b>PBAP_PROPERTY_MASK_URL</b>		(int) (1&lt;&lt;20)
	 *		<br><b>PBAP_PROPERTY_MASK_UID</b>		(int) (1&lt;&lt;21)
	 *		<br><b>PBAP_PROPERTY_MASK_KEY</b>		(int) (1&lt;&lt;22)
	 *		<br><b>PBAP_PROPERTY_MASK_NICKNAME</b>	(int) (1&lt;&lt;23)
	 *		<br><b>PBAP_PROPERTY_MASK_CATEGORIES</b>(int) (1&lt;&lt;24)
	 *		<br><b>PBAP_PROPERTY_MASK_PROID</b>		(int) (1&lt;&lt;25)
	 *		<br><b>PBAP_PROPERTY_MASK_CLASS</b>		(int) (1&lt;&lt;26)
	 *		<br><b>PBAP_PROPERTY_MASK_SORT_STRING</b>(int) (1&lt;&lt;27)
	 *		<br><b>PBAP_PROPERTY_MASK_TIME_STAMP</b>(int) (1&lt;&lt;28)</blockquote>
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqPbapDownloadToContactsProvider(java.lang.String address, int storage, int property) throws android.os.RemoteException;
/**
	 * Request to download phonebook with vCard from remote device and save to local Contacts Provider.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions
	 * {@link INfCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6
	 *		<br><b>PBAP_STORAGE_SPEEDDIAL</b>			(int) 7
	 *		<br><b>PBAP_STORAGE_FAVORITE</b>			(int) 8</blockquote>
	 * @param property download property mask. Possible storage type are:
	 *		<blockquote><b>PBAP_PROPERTY_MASK_VERSION</b>	(int) (1&lt;&lt;0)
	 *		<br><b>PBAP_PROPERTY_MASK_FN</b>		(int) (1&lt;&lt;1)
	 *		<br><b>PBAP_PROPERTY_MASK_N</b>			(int) (1&lt;&lt;2)
	 *		<br><b>PBAP_PROPERTY_MASK_PHOTO</b>		(int) (1&lt;&lt;3)
	 *		<br><b>PBAP_PROPERTY_MASK_BDAY</b>		(int) (1&lt;&lt;4)
	 *		<br><b>PBAP_PROPERTY_MASK_ADR</b>		(int) (1&lt;&lt;5)
	 *		<br><b>PBAP_PROPERTY_MASK_LABEL</b>		(int) (1&lt;&lt;6)
	 *		<br><b>PBAP_PROPERTY_MASK_TEL</b>		(int) (1&lt;&lt;7)
	 *		<br><b>PBAP_PROPERTY_MASK_EMAIL</b>		(int) (1&lt;&lt;8)
	 *		<br><b>PBAP_PROPERTY_MASK_MAILER</b>	(int) (1&lt;&lt;9)
	 *		<br><b>PBAP_PROPERTY_MASK_TZ</b>		(int) (1&lt;&lt;10)
	 *		<br><b>PBAP_PROPERTY_MASK_GEO</b>		(int) (1&lt;&lt;11)
	 *		<br><b>PBAP_PROPERTY_MASK_TITLE</b>		(int) (1&lt;&lt;12)
	 *		<br><b>PBAP_PROPERTY_MASK_ROLE</b>		(int) (1&lt;&lt;13)
	 *		<br><b>PBAP_PROPERTY_MASK_LOGO</b>		(int) (1&lt;&lt;14)
	 *		<br><b>PBAP_PROPERTY_MASK_AGENT</b>		(int) (1&lt;&lt;15)
	 *		<br><b>PBAP_PROPERTY_MASK_ORG</b>		(int) (1&lt;&lt;16)
	 *		<br><b>PBAP_PROPERTY_MASK_NOTE</b>		(int) (1&lt;&lt;17)
	 *		<br><b>PBAP_PROPERTY_MASK_REV</b>		(int) (1&lt;&lt;18)
	 *		<br><b>PBAP_PROPERTY_MASK_SOUND</b>		(int) (1&lt;&lt;19)
	 *		<br><b>PBAP_PROPERTY_MASK_URL</b>		(int) (1&lt;&lt;20)
	 *		<br><b>PBAP_PROPERTY_MASK_UID</b>		(int) (1&lt;&lt;21)
	 *		<br><b>PBAP_PROPERTY_MASK_KEY</b>		(int) (1&lt;&lt;22)
	 *		<br><b>PBAP_PROPERTY_MASK_NICKNAME</b>	(int) (1&lt;&lt;23)
	 *		<br><b>PBAP_PROPERTY_MASK_CATEGORIES</b>(int) (1&lt;&lt;24)
	 *		<br><b>PBAP_PROPERTY_MASK_PROID</b>		(int) (1&lt;&lt;25)
	 *		<br><b>PBAP_PROPERTY_MASK_CLASS</b>		(int) (1&lt;&lt;26)
	 *		<br><b>PBAP_PROPERTY_MASK_SORT_STRING</b>(int) (1&lt;&lt;27)
	 *		<br><b>PBAP_PROPERTY_MASK_TIME_STAMP</b>(int) (1&lt;&lt;28)</blockquote>
	 * @param startPos download start position.
	 * @param offset download offset.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqPbapDownloadRangeToContactsProvider(java.lang.String address, int storage, int property, int startPos, int offset) throws android.os.RemoteException;
/**
	 * Request to query the corresponding name by a given phone number from database.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackPbap#retPbapDatabaseQueryNameByNumber retPbapDatabaseQueryNameByNumber} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
     * @param target the phone number given to database query.
     */
public void reqPbapDatabaseQueryNameByNumber(java.lang.String address, java.lang.String target) throws android.os.RemoteException;
/**
	 * Request to querythe corresponding name by a given partial phone number from database.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackPbap#retPbapDatabaseQueryNameByPartialNumber retPbapDatabaseQueryNameByPartialNumber} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.
     * @param target the phone number given to database query like number.
     * @param findPosition decide which target position you want to find. Possible value are:
     *		<br>For example: target is 123.
     *		<blockquote><b>SQL_QUERY_FIND_CONTAIN</b>		(int) 0 ex. XXX<b>123</b>XXX
	 *		<br><b>SQL_QUERY_FIND_HEAD</b>					(int) 1 ex. <b>123</b>XXXXXX
	 *		<br><b>SQL_QUERY_FIND_TAIL</b>					(int) 2 ex. XXXXXX<b>123</b></blockquote>
     */
public void reqPbapDatabaseQueryNameByPartialNumber(java.lang.String address, java.lang.String target, int findPosition) throws android.os.RemoteException;
/**
	 * Request to check if nFore's PBAP database is available for query.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackPbap#retPbapDatabaseAvailable retPbapDatabaseAvailable} to be notified when database is available.
	 *
	 * <p>When nFore's PBAP database is required to access, this command has to be issued in advanced and wait for 
	 * the callback {@link UiCallbackPbap#retPbapDatabaseAvailable retPbapDatabaseAvailable}. Or the database may be crashed!
	 * <br>After nFore's PBAP database is done accessing, the database resource needs to be released. And should <b>never</b> use commands
	 * {@link UiCommandPbap#reqPbapDownloadToDatabase reqPbapDownloadToDatabase}, 
	 * {@link UiCommandPbap#reqPbapDownloadToContactsProvider reqPbapDownloadToContactsProvider},
	 * {@link UiCommandPbap#reqPbapDatabaseQueryNameByNumber reqPbapDatabaseQueryNameByNumber} or 
	 * {@link UiCommandPbap#reqPbapDatabaseQueryNameByPartialNumber reqPbapDatabaseQueryNameByPartialNumber} 
	 * before the database resource is released. 
	 * 
	 * @param address valid Bluetooth MAC address.
	 */
public void reqPbapDatabaseAvailable(java.lang.String address) throws android.os.RemoteException;
/**
	 * Request to delete phonebook data of specific address from database.
	 * 
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackPbap#retPbapDeleteDatabaseByAddressCompleted retPbapDeleteDatabaseByAddressCompleted} to be notified when database has been deleted.
	 *
	 * @param address valid Bluetooth MAC address.
	 */
public void reqPbapDeleteDatabaseByAddress(java.lang.String address) throws android.os.RemoteException;
/**
	 * Request to clean whole PBAP database.
	 *
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link UiCallbackPbap#retPbapCleanDatabaseCompleted retPbapCleanDatabaseCompleted} to be notified when database has been cleaned.
	 */
public void reqPbapCleanDatabase() throws android.os.RemoteException;
/**
	 * Request to interrupt the ongoing download from remote device.
	 *
	 * <br>Clients should register and implement callback function {@link UiCallbackPbap#onPbapStateChanged onPbapStateChanged} to be notified of subsequent result.    
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true if really try to interrupt.
	 */
public boolean reqPbapDownloadInterrupt(java.lang.String address) throws android.os.RemoteException;
/**
	 * Set PBAP download notify frequency. Will set to default value when ServiceManager restart.
	 * Default value is 0 means don't callback download notify. For example, if frequency is set to 5, every 5 contacts onPbapDownloadNofity will be notified.
	 *
	 * <br>Clients should register and implement callback function {@link INfCallbackPbap#onPbapDownloadNotify onPbapDownloadNotify} to be notified of subsequent result.
	 * Callback will be invoked if below commands are issued     
	 * {@link INfCommandPbap#reqPbapDownload reqPbapDownload}, 
	 * {@link INfCommandPbap#reqPbapDownloadRange reqPbapDownloadRange},
	 * {@link INfCommandPbap#reqPbapDownloadToDatabase reqPbapDownloadToDatabase},
	 * {@link INfCommandPbap#reqPbapDownloadRangeToDatabase reqPbapDownloadRangeToDatabase},
	 * {@link INfCommandPbap#reqPbapDownloadToContactsProvider reqPbapDownloadToContactsProvider} or 
	 * {@link INfCommandPbap#reqPbapDownloadRangeToContactsProvider reqPbapDownloadRangeToContactsProvider} 
	 *
	 * @param frequency define the callback frequency.
     *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean setPbapDownloadNotify(int frequency) throws android.os.RemoteException;
// SPP
/** 
	 * Register callback functions for SPP profile.
	 * Call this function to register callback functions for SPP profile.
	 * Allow nFore service to call back to its registered clients, which might often be UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean registerSppCallback(com.nforetek.bt.aidl.UiCallbackSpp cb) throws android.os.RemoteException;
/** 
	 * Remove callback functions for SPP profile.
     * Call this function to remove previously registered callback interface for SPP profile.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean unregisterSppCallback(com.nforetek.bt.aidl.UiCallbackSpp cb) throws android.os.RemoteException;
/** 
	 * Request to connect SPP to the remote device.
	 *
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link INfCallbackSpp#onSppStateChanged onSppStateChanged} to be notified of subsequent profile state changes.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqSppConnect(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request to disconnect the connected SPP connection to the remote device.
	 *
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link INfCallbackSpp#onSppStateChanged onSppStateChanged} to be notified of subsequent profile state changes.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqSppDisconnect(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request for the hardware Bluetooth address of the remote SPP devices.
	 * For example, "00:11:22:AA:BB:CC".
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link INfCallbackSpp#retSppConnectedDeviceAddressList retSppConnectedDeviceAddressList} to be notified of subsequent result.
	 */
public void reqSppConnectedDeviceAddressList() throws android.os.RemoteException;
/** 
	 * Check if local device is SPP connected with the remote device. 	 
	 *
	 * @param address valid Bluetooth MAC address.	 
	 * @return true if device with given address is currently connected.
	 */
public boolean isSppConnected(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request to send given data to the remote SPP device.
	 * 
	 * Data size should not be greater than 512 bytes each time. 
	 *
	 * @param address valid Bluetooth MAC address of connected device.
	 * @param sppData the data to be sent.
	 */
public void reqSppSendData(java.lang.String address, byte[] sppData) throws android.os.RemoteException;
/** 
	 * Register callback functions for HID.
	 * <br>Call this function to register callback functions for HID.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean registerHidCallback(com.nforetek.bt.aidl.UiCallbackHid cb) throws android.os.RemoteException;
/** 
	 * Remove callback functions from HID.
     * <br>Call this function to remove previously registered callback interface for HID.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean unregisterHidCallback(com.nforetek.bt.aidl.UiCallbackHid cb) throws android.os.RemoteException;
/** 
	 * Get current connection state of the remote device.
	 *
	 * @return current state of HID profile service.
	 */
public int getHidConnectionState() throws android.os.RemoteException;
/** 
	 * Check if local device is HID connected with remote device.
	 *
	 * @return true to indicate HID is connected, or false disconnected.
	 */
public boolean isHidConnected() throws android.os.RemoteException;
/** 
	 * Get the Bluetooth hardware address of HID connected remote device.
	 *
	 * @return Bluetooth hardware address as string if there is a connected HID device, or 
	 * <code>DEFAULT_ADDRESS</code> 00:00:00:00:00:00.
	 */
public java.lang.String getHidConnectedAddress() throws android.os.RemoteException;
/** 
	 * Request to connect HID to the remote device.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackHid#onHidStateChanged onHidStateChanged} to be notified of subsequent profile state changes.
	 * 
	 * <p>There is no guarantee that Hid will be connected and the sequence of state changed callback of profiles! 
	 * <br>This depends on the behavior of connected device.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqHidConnect(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request to disconnect HID to the remote device.
	 * <p>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link UiCallbackHid#onHidStateChanged onHidStateChanged} to be notified of subsequent profile state changes.
	 * 
	 * <p>There is no guarantee that HID will be disconnected and the sequence of state changed callback of profiles! 
	 * <br>This depends on the behavior of connected device.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqHidDisconnect(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request to send HID mouse command to the remote device.
	 * 
	 * It should be noticed that the function is available after HID connect success.
	 * The return value is an integer means this function has sent data to the remote device. 0 means fail.
	 * @param button : You should put the correct value to this parameter. For exmple : 0x01 means left button. 0x02 means right button.	
	 *				   Please refers to "USB HID Usage Tables, v1.12, page 67". 		   
	 * @param offset_x : You should put x-direction of mouse offset on this parameter. The range should be in (32768 ~ -32768).
	 *				   The parameter is the relative value of last position.
	 * @param offset_y : You should put y-direction of mouse offset on this parameter. The range should be in (32768 ~ -32768).
	 *				   The parameter is the relative value of last position.
	 * @param wheel : You should put wheel information of mouse offset on this parameter. The range should be in (127 ~ -127).
	 *				   The parameter is the relative value of last position.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqSendHidMouseCommand(int button, int offset_x, int offset_y, int wheel) throws android.os.RemoteException;
/** 
	 * Request to send virtual key event to the remote device.
	 * 
	 * It should be noticed that the function is available after HID connect success.
	 * The return value is an integer means this function has sent data to the remote device. 0 means fail.
	 * About the key_1 and key_2 value, please refers to "USB HID Usage Tables, v1.12, page 75-102".
	 * @param key_1 : You should put virtual key command on this parameter. For example, 0x223 means home key. 0x224 means back button.
	 * 					The range should be in (1 ~ 652).
	 * @param key_2 : You should put virtual key command on this parameter. For example, 0x223 means home key. 0x224 means back button.
	 * 					The range should be in (1 ~ 652).
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqSendHidVirtualKeyCommand(int key_1, int key_2) throws android.os.RemoteException;
// MAP
/** 
	 * Register callback functions for MAP.
	 * <br>Call this function to register callback functions for MAP.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean registerMapCallback(com.nforetek.bt.aidl.UiCallbackMap cb) throws android.os.RemoteException;
/** 
	 * Remove callback functions from MAP.
     * <br>Call this function to remove previously registered callback interface for MAP.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean unregisterMapCallback(com.nforetek.bt.aidl.UiCallbackMap cb) throws android.os.RemoteException;
/** 
	 * Request to download all messages from remote device.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link INfCallbackMap#onMapStateChanged onMapStateChanged} to be notified of subsequent profile state changes.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param folder
	 *		<p><blockquote>MAP_INBOX_OUTBOX		(int) 0
	 *		<br>MAP_INBOX_ONLY					(int) 1
	 *		<br>MAP_OUTBOX_ONLY					(int) 2</blockquote>
	 * @param isContentDownload
	 * <p><value>=false, download message list only
	 * <p><value>=true, download all messages including the contents, but this will set all messages to "read"
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqMapDownloadAllMessages(java.lang.String address, int folder, boolean isContentDownload) throws android.os.RemoteException;
/**
	 * Request to download single message from remote device.
	 * 
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link INfCallbackMap#onMapStateChanged onMapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.	
	 * @param folder
	 *		<p><blockquote>MAP_INBOX_ONLY		(int) 1
	 *		<br>MAP_OUTBOX_ONLY					(int) 2</blockquote>
	 * @param handle MAP handle
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqMapDownloadSingleMessage(java.lang.String address, int folder, java.lang.String handle) throws android.os.RemoteException;
/** 
	 * Request to download all messages from remote device and save to local database.
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link INfCallbackMap#onMapStateChanged onMapStateChanged} to be notified of subsequent profile state changes.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param folder
	 *		<p><blockquote>MAP_INBOX_OUTBOX		(int) 0
	 *		<br>MAP_INBOX_ONLY					(int) 1
	 *		<br>MAP_OUTBOX_ONLY					(int) 2</blockquote>	
	 * @param isContentDownload
	 * <p><value>=false, download message list only
	 * <p><value>=true, download all messages including the contents, but this will set all messages to "read"
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean reqMapDownloadAllMessagesToDatabase(java.lang.String address, int folder, boolean isContentDownload) throws android.os.RemoteException;
/**
	 * Request to download single message from remote device and save to local database.
	 * 
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link INfCallbackMap#onMapStateChanged onMapStateChanged} to be notified of subsequent result.
	 *
	 * @param address valid Bluetooth MAC address.	
	 * @param folder
	 *		<p><blockquote>MAP_INBOX_ONLY		(int) 1
	 *		<br>MAP_OUTBOX_ONLY					(int) 2</blockquote>
	 * @param handle MAP handle
	 * @return true to indicate the operation is successful, or false erroneous.		 
	 */
public boolean reqMapDownloadSingleMessageToDatabase(java.lang.String address, int folder, java.lang.String handle) throws android.os.RemoteException;
/**
	 * Request to register notification when there is new message on remote device with given Bluetooth hardware address.
	 * Valid Bluetooth hardware addresses must be in a format such as "00:11:22:33:AA:BB".
	 * <br>This is an asynchronous call: it will return immediately, and clients should register and implement callback functions 
	 * {@link INfCallbackMap#onMapStateChanged onMapStateChanged} to be notified if register notification success.
	 * and implement callback function {@link INfCallbackMap#onMapNewMessageReceivedEvent onMapNewMessageReceivedEvent}
	 * , {@link INfCallbackMap#onMapMemoryAvailableEvent onMapMemoryAvailableEvent}
	 * , {@link INfCallbackMap#onMapMessageSendingStatusEvent onMapMessageSendingStatusEvent}
	 * , {@link INfCallbackMap#onMapMessageDeliverStatusEvent onMapMessageDeliverStatusEvent}
	 * , {@link INfCallbackMap#onMapMessageShiftedEvent onMapMessageShiftedEvent}
	 * , {@link INfCallbackMap#onMapMessageDeletedEvent onMapMessageDeletedEvent}
	 * to be notified of receivced new message.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param downloadNewMessage if true, download the new message, including sender and message contents; if false, only notification will be sent
	 */
public boolean reqMapRegisterNotification(java.lang.String address, boolean downloadNewMessage) throws android.os.RemoteException;
/**
	 * Request to unregister new message notification on remote device with given Bluetooth hardware address.
	 * Valid Bluetooth hardware addresses must be in a format such as "00:11:22:33:AA:BB". 
	 *
	 * @param address valid Bluetooth MAC address.
	 */
public void reqMapUnregisterNotification(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Return true if the new message notification is registered on device with given address.
	 *
	 * @param address valid Bluetooth MAC address.	 
	 * @return true if registered.
	 */
public boolean isMapNotificationRegistered(java.lang.String address) throws android.os.RemoteException;
/**
	 * Request to interrupt the ongoing download on remote device.
	 * 
	 * Clients should register and implement callback function {@link INfCallbackMap#onMapStateChanged onMapStateChanged} to be notified of subsequent result.    
	 *
	 * @param address valid Bluetooth MAC address.
	 * @return true if really try to interrupt.
	 */
public boolean reqMapDownloadInterrupt(java.lang.String address) throws android.os.RemoteException;
/**
	 * Request to check if database is available for query
	 * Client should register and implement {@link INfCallbackMap#retMapDatabaseAvailable retMapDatabaseAvailable} 
	 * to be notified when database is available.
	 *
	 * @param address valid Bluetooth MAC address.	 
	 */
public void reqMapDatabaseAvailable() throws android.os.RemoteException;
/**
	 * Request to delete MAP data by specific address
	 * Client should register and implement {@link INfCallbackMap#retMapDeleteDatabaseByAddressCompleted retMapDeleteDatabaseByAddressCompleted} 
	 * to be notified when database is available.
	 *
	 * @param address valid Bluetooth MAC address.	 
	 */
public void reqMapDeleteDatabaseByAddress(java.lang.String address) throws android.os.RemoteException;
/**
	 * Request to clean database of MAP.
	 * This is an asynchronous call: it will return immediately, and clients should register and implement callback function
	 * {@link INfCallbackMap#retMapCleanDatabaseCompleted retMapCleanDatabaseCompleted} to be notified when database has been cleaned.	 
	 */
public void reqMapCleanDatabase() throws android.os.RemoteException;
/** 
	 * Request for the current download state of remote connected MAP device with given Bluetooth hardware address.
	 * Valid Bluetooth hardware addresses must be in a format such as "00:11:22:33:AA:BB".	 
	 *
	 * @param address valid Bluetooth MAC address of connected device.	 
	 * @return current state of MAP profile service.
	 */
public int getMapCurrentState(java.lang.String address) throws android.os.RemoteException;
/** 
	 * Request for the current register state of remote connected MAP device with given Bluetooth hardware address.
	 * Valid Bluetooth hardware addresses must be in a format such as "00:11:22:33:AA:BB".	 
	 *
	 * @param address valid Bluetooth MAC address of connected device.	 
	 * @return current state of MAP profile service.
	 */
public int getMapRegisterState(java.lang.String address) throws android.os.RemoteException;
/**
	 * Request to send message on remote device.
	 * 
	 * Clients should register and implement callback function {@link INfCallbackMap#retMapSendMessageCompleted retMapSendMessageCompleted} to be notified of subsequent result.    
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param message send context.
	 * @param target phone number of target.
	 */
public boolean reqMapSendMessage(java.lang.String address, java.lang.String message, java.lang.String target) throws android.os.RemoteException;
/**
	 * Request to delete message on remote device.
	 * 
	 * Clients should register and implement callback function {@link INfCallbackMap#retMapDeleteMessageCompleted retMapDeleteMessageCompleted} to delete a message in remote device.
	 * Suggest that the message handle should be updated by downloading message listing before deleting a message.
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param folder which folder message download from. Possible values are
     *		<br>FOLDER_STRUCTURE_INBOX					(int) 0
	 * 		<br>FOLDER_STRUCTURE_SENT					(int) 1
	 * @param handle MAP handle
	 */
public boolean reqMapDeleteMessage(java.lang.String address, int folder, java.lang.String handle) throws android.os.RemoteException;
/**
	 * Request to change read status of message.
	 * 
	 * Clients should register and implement callback function {@link INfCallbackMap#retMapChangeReadStatusCompleted retMapChangeReadStatusCompleted} to modify a read status in remote device.    
	 *
	 * @param address valid Bluetooth MAC address.
	 * @param folder which folder message download from. Possible values are
     *		<br>FOLDER_STRUCTURE_INBOX					(int) 0
	 * 		<br>FOLDER_STRUCTURE_SENT					(int) 1
	 * @param handle MAP handle
	 * @param isReadStatus that "true" (=read) or "false" (=unread) for the "readStatus" indicator
	 */
public boolean reqMapChangeReadStatus(java.lang.String address, int folder, java.lang.String handle, boolean isReadStatus) throws android.os.RemoteException;
/**
	 * Set MAP download notify frequency. Will set to default value when ServiceManager restart.
	 * Default value is 0 means don't callback download notify. For example, if frequency is set to 5, every 5 contacts onPbapDownloadNofity will be notified.
	 *
	 * <br>Clients should register and implement callback function {@link INfCallbackMap#onMapDownloadNotify onMapDownloadNotify} to be notified of subsequent result.
	 * Callback will be invoked if below commands are issued     
	 * {@link INfCommandMap#reqMapDownloadAllMessages reqMapDownloadAllMessages} or
	 * {@link INfCommandMap#reqMapDownloadAllMessagesToDatabase reqMapDownloadAllMessagesToDatabase}
	 *
	 * @param frequency define the callback frequency.
	 * <p><value>=0 all messages would be downloaded first, and inserted to database. Only one callback would be invocated.
	 * <p><value>>0 Callbacks would be invocated every "frequency" messages have been downloaded and inserted to database. 
	 *
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean setMapDownloadNotify(int frequency) throws android.os.RemoteException;
// OPP
/**
	 * Register callback functions for OPP.
	 * <br>Call this function to register callback functions for OPP.
	 * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
	 *
	 * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean registerOppCallback(com.nforetek.bt.aidl.UiCallbackOpp cb) throws android.os.RemoteException;
/** 
	 * Remove callback functions from OPP.
     * <br>Call this function to remove previously registered callback interface for OPP.
     * 
     * @param cb callback interface instance.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean unregisterOppCallback(com.nforetek.bt.aidl.UiCallbackOpp cb) throws android.os.RemoteException;
/** 
	 * Request to set Opp file storage path.
	 * <br>This is an asynchronous call: it will return immediately. 	 
	 *
	 * @param path is under sdcard path. For example, if path is set as /nfore, the actual path would be /sdcard/nfore.
	 * @return true to indicate the operation is successful, or false erroneous.
	 */
public boolean setOppFilePath(java.lang.String path) throws android.os.RemoteException;
/** 
	 * Get Opp file storage path.
	 *
	 * @return Opp file storage path
	 */
public java.lang.String getOppFilePath() throws android.os.RemoteException;
/** 
	 * Accept to receive file.
     * <br>Call this function to accept file transfer from remote device.
     * 
     * @param accept true or false to accept file transfer.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean reqOppAcceptReceiveFile(boolean accept) throws android.os.RemoteException;
/** 
	 * Accept to receive file.
     * <br>Call this function to accept file transfer from remote device.
     * 
     * @param accept true or false to accept file transfer.
	 * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean reqOppInterruptReceiveFile() throws android.os.RemoteException;
public void setTargetAddress(java.lang.String address) throws android.os.RemoteException;
public java.lang.String getTargetAddress() throws android.os.RemoteException;
public void reqAvrcpUpdateSongStatus() throws android.os.RemoteException;
// Gatt
/** 
     * Check if Gatt Server service is ready.
     */
public boolean isGattServiceReady() throws android.os.RemoteException;
/** 
     * Register callback functions for Gatt Server.
     * <br>Call this function to register callback functions for Gatt Server.
     * <br>Allow nFore service to call back to its registered clients, which is usually the UI application.
     *
     * @param cb callback interface instance.
     * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean registerGattServerCallback(com.nforetek.bt.aidl.UiCallbackGattServer cb) throws android.os.RemoteException;
/** 
     * Remove callback functions from Gatt Server.
     * <br>Call this function to remove previously registered callback interface for Gatt Server.
     * 
     * @param cb callback interface instance.
     * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean unregisterGattServerCallback(com.nforetek.bt.aidl.UiCallbackGattServer cb) throws android.os.RemoteException;
/** 
     * Get current connection state of the remote device.
     * 
     * @return current state of Gatt Server profile service.
     */
public int getGattServerConnectionState() throws android.os.RemoteException;
/** 
     * Disconnects an established connection, or cancels a connection attempt
     * currently in progress.
     * <br>This is an asynchronous call: it will return immediately, and clients should register 
     * and implement callback functions {@link INfCallbackGattServer#onGattServerStateChanged onGattServerStateChanged} 
     * to be notified of subsequent profile state changes.
     * 
     * @param address Remote device address
     * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean reqGattServerDisconnect(java.lang.String address) throws android.os.RemoteException;
/** 
     * Request to add Gatt service with service type and UUID.
     *
     * @param srvcType service type. Possible values are:
     *      <br>GATT_SERVICE_TYPE_PRIMARY                (int) 0
     *      <br>GATT_SERVICE_TYPE_SECONDARY              (int) 1
     * 
     * @param srvcUuid service UUID.
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean reqGattServerBeginServiceDeclaration(int srvcType, android.os.ParcelUuid srvcUuid) throws android.os.RemoteException;
/** 
     * Request to add Gatt characteristic with UUID, properties and permissions with 
     * defined service.
     *
     * @param charUuid characteristic UUID.
     * @param properties Characteristic property. Possible values are:
     *      <br>GATT_CHARACTERISTIC_PROPERTY_BROADCAST              (int) 0x01
     *      <br>Characteristic is broadcastable.
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_READ                   (int) 0x02
     *      <br>Characteristic is readable.
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_WRITE_NO_RESPONSE      (int) 0x04
     *      <br>Characteristic can be written without response.
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_WRITE                  (int) 0x08
     *      <br>Characteristic can be written.
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_NOTIFY                 (int) 0x10
     *      <br>Characteristic supports notification
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_INDICATE               (int) 0x20
     *      <br>Characteristic supports indication
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_SIGNED_WRITE           (int) 0x30
     *      <br>Characteristic supports write with signature
     *
     *      <br>GATT_CHARACTERISTIC_PROPERTY_EXTENDED_PROPS         (int) 0x40
     *      <br>Characteristic has extended properties
     *
     * @param permissions Characteristic permission. Attribute permissions 
     *  are a combination of access permissions, authentication
     *  permissions and authorization permissions. Possible values are:
     *      <br>GATT_CHARACTERISTIC_PERMISSION_READ                 (int) 0x01
     *      <br>Characteristic read permission
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_READ_ENCRYPTED        (int) 0x02
     *      <br>Allow encrypted read operations
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_READ_ENCRYPTED_MITM    (int) 0x04
     *      <br>Allow reading with man-in-the-middle protection
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_WRITE                  (int) 0x10
     *      <br>Characteristic write permission
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_WRITE_ENCRYPTED         (int) 0x20
     *      <br>Allow encrypted writes
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_WRITE_ENCRYPTED_MITM    (int) 0x40
     *      <br>Allow encrypted writes with man-in-the-middle protection
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_WRITE_SIGNED             (int) 0x80
     *      <br>Allow signed write operations
     *
     *      <br>GATT_CHARACTERISTIC_PERMISSION_WRITE_SIGNED_MITM        (int) 0x100
     *      <br>Allow signed write operations with man-in-the-middle protection
     *
     *  For example, if this characteristic could be read/write with authentication permission,
     *  this value could be set as 0x22. (read encrypted and write encrypted)
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean reqGattServerAddCharacteristic(android.os.ParcelUuid charUuid, int properties, int permissions) throws android.os.RemoteException;
/** 
     * Request to add Gatt characteristic descriptor with UUID and permissions with 
     * defined characteristic.
     *
     * @param descUuid descriptor UUID.
     * @param permissions Descriptor permission. Attribute descriptor permissions 
     *  are a combination of access permissions, authentication
     *  permissions and authorization permissions. Possible values are:
     *      <br>GATT_DESCRIPTOR_PERMISSION_READ                 (int) 0x01
     *      <br>Descriptor read permission
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_READ_ENCRYPTED        (int) 0x02
     *      <br>Allow encrypted read operations
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_READ_ENCRYPTED_MITM    (int) 0x04
     *      <br>Allow reading with man-in-the-middle protection
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_WRITE                  (int) 0x10
     *      <br>Descriptor write permission
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_WRITE_ENCRYPTED         (int) 0x20
     *      <br>Allow encrypted writes
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_WRITE_ENCRYPTED_MITM    (int) 0x40
     *      <br>Allow encrypted writes with man-in-the-middle protection
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_WRITE_SIGNED             (int) 0x80
     *      <br>Allow signed write operations
     *
     *      <br>GATT_DESCRIPTOR_PERMISSION_WRITE_SIGNED_MITM        (int) 0x100
     *      <br>Allow signed write operations with man-in-the-middle protection
     *
     *  For example, if this characteristic descriptor could be read/write with authentication permission,
     *  this value could be set as 0x22. (read encrypted and write encrypted)
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean reqGattServerAddDescriptor(android.os.ParcelUuid descUuid, int permissions) throws android.os.RemoteException;
/** 
     * Finish Service declaration. The service and related characteristics and descriptors 
     * are registered after end service declaration.
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean reqGattServerEndServiceDeclaration() throws android.os.RemoteException;
/** 
     * Request to remove registered Gatt service with service type and UUID.
     * <br>This is an asynchronous call: it will return immediately, and clients should register 
     * and implement callback functions {@link INfCallbackGattServer#onGattServerServiceDeleted onGattServerServiceDeleted} 
     * to be notified of services deleted.
     *
     * @param srvcType service type.
     * @param srvcUuid service UUID.
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean reqGattServerRemoveService(int srvcType, android.os.ParcelUuid srvcUuid) throws android.os.RemoteException;
/** 
     * Request to remove all registered Gatt services.
     * <br>This is an asynchronous call: it will return immediately, and clients should register 
     * and implement callback functions {@link INfCallbackGattServer#onGattServerServiceDeleted onGattServerServiceDeleted} 
     * to be notified of services deleted.
     *    
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean reqGattServerClearServices() throws android.os.RemoteException;
/** 
     * Request to start or finish advertisement broadcast
     * 
     * <br>This is an asynchronous call: it will return immediately, and clients should register 
     * and implement callback functions {@link INfCallbackGattServer#onGattServerStateChanged onGattServerStateChanged} 
     * to be notified of subsequent profile state changes.
     * @param listen start listen or not.
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean reqGattServerListen(boolean listen) throws android.os.RemoteException;
/** 
     * Request to send response with read and write characteristic request to Gatt clients.
     *  
     * @param address valid Bluetooth MAC address.
     * @param requestId The ID of the request that was received with the callback
     * @param status The status of the request to be sent to the remote devices
     *               Possible values are:
     *      <br>GATT_STATUS_SUCCESS                (int) 0x00
     *      <br>Operation success.
     *
     *      <br>GATT_STATUS_INVALID_HANDLE         (int) 0x01
     *      <br>Invalid Handle
     *
     *      <br>GATT_STATUS_READ_NOT_PERMIT        (int) 0x02
     *      <br>Read Not Permitted
     *
     *      <br>GATT_STATUS_WRITE_NOT_PERMIT       (int) 0x03
     *      <br>Write Not Permitted
     *
     *      <br>GATT_STATUS_INVALID_PDU            (int) 0x04
     *      <br>Invalid PDU
     *
     *      <br>GATT_STATUS_INSUF_AUTHENTICATION   (int) 0x05
     *      <br>Insufficient Authentication
     *
     *      <br>GATT_STATUS_REQ_NOT_SUPPORTED      (int) 0x06
     *      <br>Request Not Supported
     *
     *      <br>GATT_STATUS_INVALID_OFFSET         (int) 0x07
     *      <br>Invalid Offset
     *
     *      <br>GATT_STATUS_INSUF_AUTHORIZATION    (int) 0x08
     *      <br>Insufficient Authorization
     *
     *      <br>GATT_STATUS_PREPARE_Q_FULL         (int) 0x09
     *      <br>Prepare Queue Full
     *
     *      <br>GATT_STATUS_NOT_FOUND              (int) 0x0a
     *      <br>Attribute Not Found
     *
     *      <br>GATT_STATUS_NOT_LONG               (int) 0x0b
     *      <br>Attribute Not Long
     *
     *      <br>GATT_STATUS_INSUF_KEY_SIZE         (int) 0x0c
     *      <br>Insufficient Encryption Key Size
     *
     *      <br>GATT_STATUS_INVALID_ATTR_LEN       (int) 0x0d
     *      <br>Invalid Attribute Value Length
     *
     *      <br>GATT_STATUS_ERR_UNLIKELY           (int) 0x0e
     *      <br>Unlikely Error
     *
     *      <br>GATT_STATUS_INSUF_ENCRYPTION       (int) 0x0f
     *      <br>Insufficient Encryption
     *
     *      <br>GATT_STATUS_UNSUPPORT_GRP_TYPE     (int) 0x10
     *      <br>Unsupported Group Type.
     *
     *      <br>GATT_STATUS_INSUF_RESOURCE         (int) 0x11
     *      <br>Insufficient Resources
     *
     * @param offset Value offset for partial read/write response
     * @param value The value of the attribute that was read/written (optional)
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean reqGattServerSendResponse(java.lang.String address, int requestId, int status, int offset, byte[] value) throws android.os.RemoteException;
/** 
     * Request to send characteristic notification values to Gatt clients.
     *  
     * @param address valid Bluetooth MAC address.
     * @param srvcType service type
     * @param srvcUuid service UUID
     * @param charUuid characteristic UUID
     * @param confirm true to request confirmation from the client (indication),
     *                false to send a notification
     * @param value The value to notify remote device.
     *
     * @return true to indicate the operation is successful, or false erroneous.
     */
public boolean reqGattServerSendNotification(java.lang.String address, int srvcType, android.os.ParcelUuid srvcUuid, android.os.ParcelUuid charUuid, boolean confirm, byte[] value) throws android.os.RemoteException;
/** 
     * Get GATT added service UUID list.
     *
     * @return Added Gatt service UUID list
     */
public java.util.List<android.os.ParcelUuid> getGattAddedGattServiceUuidList() throws android.os.RemoteException;
/** 
     * Get GATT added characteristic UUID list.
     *
     * @param srvcUuid service UUID
     *
     * @return Added Gatt characteristic UUID list
     */
public java.util.List<android.os.ParcelUuid> getGattAddedGattCharacteristicUuidList(android.os.ParcelUuid srvcUuid) throws android.os.RemoteException;
/** 
     * Get GATT added descriptor UUID list.
     *
     * @param srvcUuid service UUID
     * @param charUuid characteristic UUID
     *
     * @return Added Gatt descriptor UUID list
     */
public java.util.List<android.os.ParcelUuid> getGattAddedGattDescriptorUuidList(android.os.ParcelUuid srvcUuid, android.os.ParcelUuid charUuid) throws android.os.RemoteException;
}
