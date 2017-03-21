/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\LXS\\Desktop\\BtPhone\\src\\com\\nforetek\\bt\\aidl\\UiCallbackMap.aidl
 */
package com.nforetek.bt.aidl;
/**
 * The callback interface for Message Access Profile (MAP).
 * <br>UI program should implement all methods of this interface 
 * for receiving possible callbacks from nFore service.
 * <br>The naming principle of callback in this Doc is as below,
 *		<blockquote><b>retXXX()</b> : must be the callback of requested API.
 *		<br>		<b>onXXX()</b>  : could be the callback for updated values or the callback from requested API.</blockquote>
 *
 * <p> The constant variables in this Doc could be found and referred by importing
 * 		<br><blockquote>com.nforetek.bt.res.NfDef</blockquote>
 * <p> with prefix NfDef class name. Ex : <code>NfDef.DEFAULT_ADDRESS</code>
 *
 * <p> Bluetooth hardware addresses would be in a format such as "00:11:22:33:AA:BB".
 *
 * @see INfCommandMap
 */
public interface UiCallbackMap extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.nforetek.bt.aidl.UiCallbackMap
{
private static final java.lang.String DESCRIPTOR = "com.nforetek.bt.aidl.UiCallbackMap";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.nforetek.bt.aidl.UiCallbackMap interface,
 * generating a proxy if needed.
 */
public static com.nforetek.bt.aidl.UiCallbackMap asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.nforetek.bt.aidl.UiCallbackMap))) {
return ((com.nforetek.bt.aidl.UiCallbackMap)iin);
}
return new com.nforetek.bt.aidl.UiCallbackMap.Stub.Proxy(obj);
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
case TRANSACTION_onMapServiceReady:
{
data.enforceInterface(DESCRIPTOR);
this.onMapServiceReady();
reply.writeNoException();
return true;
}
case TRANSACTION_onMapStateChanged:
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
this.onMapStateChanged(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_retMapDownloadedMessage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
java.lang.String _arg4;
_arg4 = data.readString();
java.lang.String _arg5;
_arg5 = data.readString();
int _arg6;
_arg6 = data.readInt();
int _arg7;
_arg7 = data.readInt();
boolean _arg8;
_arg8 = (0!=data.readInt());
java.lang.String _arg9;
_arg9 = data.readString();
java.lang.String _arg10;
_arg10 = data.readString();
this.retMapDownloadedMessage(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10);
reply.writeNoException();
return true;
}
case TRANSACTION_onMapNewMessageReceivedEvent:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
this.onMapNewMessageReceivedEvent(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_onMapDownloadNotify:
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
this.onMapDownloadNotify(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_retMapDatabaseAvailable:
{
data.enforceInterface(DESCRIPTOR);
this.retMapDatabaseAvailable();
reply.writeNoException();
return true;
}
case TRANSACTION_retMapDeleteDatabaseByAddressCompleted:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.retMapDeleteDatabaseByAddressCompleted(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_retMapCleanDatabaseCompleted:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.retMapCleanDatabaseCompleted(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_retMapSendMessageCompleted:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.retMapSendMessageCompleted(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_retMapDeleteMessageCompleted:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.retMapDeleteMessageCompleted(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_retMapChangeReadStatusCompleted:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.retMapChangeReadStatusCompleted(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onMapMemoryAvailableEvent:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _arg2;
_arg2 = (0!=data.readInt());
this.onMapMemoryAvailableEvent(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onMapMessageSendingStatusEvent:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _arg2;
_arg2 = (0!=data.readInt());
this.onMapMessageSendingStatusEvent(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onMapMessageDeliverStatusEvent:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _arg2;
_arg2 = (0!=data.readInt());
this.onMapMessageDeliverStatusEvent(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onMapMessageShiftedEvent:
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
int _arg4;
_arg4 = data.readInt();
this.onMapMessageShiftedEvent(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_onMapMessageDeletedEvent:
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
this.onMapMessageDeletedEvent(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.nforetek.bt.aidl.UiCallbackMap
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
	 * Callback to inform MAP Service is ready.
	 */
@Override public void onMapServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onMapServiceReady, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform change in MAP state of remote device with given Bluetooth hardware address.
	 * 
	 * The possible values of state in this profile are 
	 * 		<p><blockquote>STATE_NOT_INITIALIZED		(int) 100
	 * 		<br>STATE_READY								(int) 110
	 * 		<br>STATE_CONNECTED_REGISTERED				(int) 150
	 * 		<br>STATE_DOWNLOADING						(int) 160</blockquote>
	 * 
	 * On state STATE_NOT_INITIALIZED and STATE_READY, parameter address might contain unavailable content or 
	 * DEFAULT_ADDRESS , which is 00:00:00:00:00:00.
	 * STATE_CONNECTED implies the message downloading or database updating.
	 *
	 * @param address: Bluetooth MAC address of remote device which involves state changed. Only valid for states greater than STATE_READY.
	 * @param prevState: the previous state. 
	 * @param newState: the new state.
	 * @param reason: the reason of state changed. Possible values are
	 *		<br>MAP_REASON_NONE  											(int) 0
	 * 		<br>MAP_REASON_BAD_PARAMS  					                    (int) 1
	 * 		<br>MAP_REASON_DISCONNECT_FROM_LOCAL					        (int) 2
	 * 		<br>MAP_REASON_DISCONNECT_BY_PEER				                (int) 3	
	 * 		<br>MAP_REASON_INTERRUPT									    (int) 4
	 *		<br>MAP_REASON_DOWNLOAD_FINISH									(int) 5
 	 *		<br>MAP_REASON_PEER_NO_MAP_SERVICE								(int) 6
	 *		<br>MAP_REASON_TIMEOUT								            (int) 7
	 *		<br>MAP_REASON_DOWNLOAD_FAIL								    (int) 8
	 * Otherwise, the reason is -1.
     */
@Override public void onMapStateChanged(java.lang.String address, int prevState, int newState, int reason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(prevState);
_data.writeInt(newState);
_data.writeInt(reason);
mRemote.transact(Stub.TRANSACTION_onMapStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform response to {@link INfCallbackMap#reqMapDownloadAllMessages reqMapDownloadAllMessages} or
	 * {@link INfCallbackMap#reqMapDownloadSingleMessage reqMapDownloadSingleMessage}
	 * for remote connected device with given Bluetooth hardware address.
	 *
     * @param address Bluetooth MAC address of remote device.
     * @param handle MAP message handle, use this to download detail message. Change when disconnected.
     * @param senderName sender name.
     * @param senderNumber sender number.
     * @param recipientNumber recipient number.
     * @param date message receive date, ex: 20101010T101010Z means 2015/10/10 10:10:10
     * @param type message type.
     * @param folder which folder message download from. Possible values are
     *		<br>MAP_FOLDER_STRUCTURE_INBOX					(int) 0
	 * 		<br>MAP_FOLDER_STRUCTURE_SENT					(int) 1
	 * @param isReadStatus indicates the message is read (=true) or unread (=false).
     * @param subject message subject.
     * @param message message content.
     */
@Override public void retMapDownloadedMessage(java.lang.String address, java.lang.String handle, java.lang.String senderName, java.lang.String senderNumber, java.lang.String recipientNumber, java.lang.String date, int type, int folder, boolean isReadStatus, java.lang.String subject, java.lang.String message) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(handle);
_data.writeString(senderName);
_data.writeString(senderNumber);
_data.writeString(recipientNumber);
_data.writeString(date);
_data.writeInt(type);
_data.writeInt(folder);
_data.writeInt(((isReadStatus)?(1):(0)));
_data.writeString(subject);
_data.writeString(message);
mRemote.transact(Stub.TRANSACTION_retMapDownloadedMessage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the new message received on the remote device.
	 * This callback might be invocated due to {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification}.
	 * 
	 * If parameter downloadNewMessage of {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification} is 
	 * set to false, the parameter sender and message would be empty string.
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param handle MAP message handle.
     * @param sender Sender of the message. 
     * @param message Message content. 
     * The parameters "sender" and "message" are only available if parameter downloadNewMessage of {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification} is set to true. 
     */
@Override public void onMapNewMessageReceivedEvent(java.lang.String address, java.lang.String handle, java.lang.String sender, java.lang.String message) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(handle);
_data.writeString(sender);
_data.writeString(message);
mRemote.transact(Stub.TRANSACTION_onMapNewMessageReceivedEvent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the specified number of messages have been downloaded from the remote device.
	 * 
	 * This callback might be invocated due to {@link INfCommandMap#setMapDownloadNotify setMapDownloadNotify} with 
	 * non-zero parameter notifyFreq set.
     * 
	 * @param address Bluetooth MAC address of remote device.
	 * @param folder which folder message download from. Possible values are
     *		<br>MAP_FOLDER_STRUCTURE_INBOX					(int) 0
	 * 		<br>MAP_FOLDER_STRUCTURE_SENT					(int) 1
	 * @param totalMessages total number of messages would be downloaded
	 * @param currentMessages the number of messages have been downloaded
     */
@Override public void onMapDownloadNotify(java.lang.String address, int folder, int totalMessages, int currentMessages) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(folder);
_data.writeInt(totalMessages);
_data.writeInt(currentMessages);
mRemote.transact(Stub.TRANSACTION_onMapDownloadNotify, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform response to {@link INfCommandMap#reqMapDatabaseAvailable reqMapDatabaseAvailable}
	 * 
	 * When this callback is invocated, it means database is available.
	 *
     */
@Override public void retMapDatabaseAvailable() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_retMapDatabaseAvailable, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     *  Callback to inform response to {@link INfCommandMap#reqMapDeleteDatabaseByAddress reqMapDeleteDatabaseByAddress}
     *
     *  @param address which address delete from table
     *  @param isSuccess means success or not
     */
@Override public void retMapDeleteDatabaseByAddressCompleted(java.lang.String address, boolean isSuccess) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(((isSuccess)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_retMapDeleteDatabaseByAddressCompleted, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform response to {@link INfCommandMap#reqMapCleanDatabase reqMapCleanDatabase}
	 * when database has been cleaned.
	 *
	 *  @param isSuccess means success or not
	 */
@Override public void retMapCleanDatabaseCompleted(boolean isSuccess) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isSuccess)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_retMapCleanDatabaseCompleted, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform response to {@link INfCommandMap#reqMapSendMessage reqMapSendMessage}
	 *
	 *  @param address Bluetooth MAC address of remote device.
	 *  @param target phone number of target.
	 *  @param state Success or failed reason.
	 */
@Override public void retMapSendMessageCompleted(java.lang.String address, java.lang.String target, int state) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(target);
_data.writeInt(state);
mRemote.transact(Stub.TRANSACTION_retMapSendMessageCompleted, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform response to {@link INfCommandMap#reqMapDeleteMessage reqMapDeleteMessage}
	 *
	 *  @param address Bluetooth MAC address of remote device.
	 *  @param handle MAP handle.
	 *  @param reason the reason of state changed. Possible values are
	 *		<br>REASON_SUCCESS											(int) 0
	 * 		<br>REASON_BAD_HANDLE										(int) 1
	 * 		<br>REASON_TIMEOUT											(int) 2
	 * 		<br>REASON_DELETE_FAIL										(int) 3
	 * Otherwise, the reason is -1.
	 */
@Override public void retMapDeleteMessageCompleted(java.lang.String address, java.lang.String handle, int reason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(handle);
_data.writeInt(reason);
mRemote.transact(Stub.TRANSACTION_retMapDeleteMessageCompleted, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform response to {@link INfCommandMap#reqChangeMapReadStatus reqChangeMapReadStatus}
	 *
	 * @param address Bluetooth MAC address of remote device.
	 * @param handle MAP handle.
	 * @param reason the reason of state changed. Possible values are
	 *		<br>REASON_SUCCESS											(int) 0
	 * 		<br>REASON_BAD_HANDLE										(int) 1
	 * 		<br>REASON_TIMEOUT											(int) 2
	 * 		<br>REASON_CHANGE_STATUS_FAIL								(int) 3
	 * Otherwise, the reason is -1.
	 */
@Override public void retMapChangeReadStatusCompleted(java.lang.String address, java.lang.String handle, int reason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(handle);
_data.writeInt(reason);
mRemote.transact(Stub.TRANSACTION_retMapChangeReadStatusCompleted, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the memory available on the remote device.
	 * This callback might be invocated due to {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification}.
	 * 
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param structure which folder is available. Possible values are
	 *		<br>MAP_FOLDER_STRUCTURE_INBOX										(int) 0
	 * 		<br>MAP_FOLDER_STRUCTURE_SENT										(int) 1
	 * 		<br>MAP_FOLDER_STRUCTURE_DELETED									(int) 2
	 * 		<br>MAP_FOLDER_STRUCTURE_OUTBOX										(int) 3
	 * 		<br>MAP_FOLDER_STRUCTURE_DRAFT										(int) 4
     * @param available true means memory available, and false means memory full.
     */
@Override public void onMapMemoryAvailableEvent(java.lang.String address, int structure, boolean available) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(structure);
_data.writeInt(((available)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onMapMemoryAvailableEvent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the message sending status on the remote device.
	 * This callback might be invocated due to {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification}.
	 * 
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param handle MAP handle.
     * @param isSuccess sending success or not.
     */
@Override public void onMapMessageSendingStatusEvent(java.lang.String address, java.lang.String handle, boolean isSuccess) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(handle);
_data.writeInt(((isSuccess)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onMapMessageSendingStatusEvent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the message delivery status on the remote device.
	 * This callback might be invocated due to {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification}.
	 * 
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param handle MAP handle.
     * @param isSuccess deliver success or not
     */
@Override public void onMapMessageDeliverStatusEvent(java.lang.String address, java.lang.String handle, boolean isSuccess) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(handle);
_data.writeInt(((isSuccess)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onMapMessageDeliverStatusEvent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the message shifted on the remote device.
	 * This callback might be invocated due to {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification}.
	 * 
	 *
	 * @param address Bluetooth MAC address of remote device.
	 * @param handle MAP handle.
     * @param type Possible values are
	 *		<br>MAP_TYPE_SMS_GSM										(int) 0
	 * 		<br>MAP_TYPE_SMS_CDMA										(int) 1
	 * 		<br>MAP_TYPE_SMS_MMS										(int) 2
	 * 		<br>MAP_TYPE_SMS_EMAIL										(int) 3
     * @param newFolder shift to which folder. Possible values are
	 *		<br>MAP_FOLDER_STRUCTURE_INBOX										(int) 0
	 * 		<br>MAP_FOLDER_STRUCTURE_SENT										(int) 1
	 * 		<br>MAP_FOLDER_STRUCTURE_DELETED									(int) 2
	 * 		<br>MAP_FOLDER_STRUCTURE_OUTBOX										(int) 3
	 * 		<br>MAP_FOLDER_STRUCTURE_DRAFT										(int) 4
	 * @param oldFolder shift from which folder. Possible values are
	 *		<br>MAP_FOLDER_STRUCTURE_INBOX										(int) 0
	 * 		<br>MAP_FOLDER_STRUCTURE_SENT										(int) 1
	 * 		<br>MAP_FOLDER_STRUCTURE_DELETED									(int) 2
	 * 		<br>MAP_FOLDER_STRUCTURE_OUTBOX										(int) 3
	 * 		<br>MAP_FOLDER_STRUCTURE_DRAFT										(int) 4
     */
@Override public void onMapMessageShiftedEvent(java.lang.String address, java.lang.String handle, int type, int newFolder, int oldFolder) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(handle);
_data.writeInt(type);
_data.writeInt(newFolder);
_data.writeInt(oldFolder);
mRemote.transact(Stub.TRANSACTION_onMapMessageShiftedEvent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the message deleted on the remote device.
	 * This callback might be invocated due to {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification}.
	 * 
	 *
	 * @param address Bluetooth MAC address of remote device.
	 * @param handle MAP handle.
     * @param type Possible values are
	 *		<br>MAP_TYPE_SMS_GSM										(int) 0
	 * 		<br>MAP_TYPE_SMS_CDMA										(int) 1
	 * 		<br>MAP_TYPE_SMS_MMS										(int) 2
	 * 		<br>MAP_TYPE_SMS_EMAIL										(int) 3
     * @param folder delete from which folder. Possible values are
	 *		<br>MAP_FOLDER_STRUCTURE_INBOX										(int) 0
	 * 		<br>MAP_FOLDER_STRUCTURE_SENT										(int) 1
	 * 		<br>MAP_FOLDER_STRUCTURE_DELETED									(int) 2
	 * 		<br>MAP_FOLDER_STRUCTURE_OUTBOX										(int) 3
	 * 		<br>MAP_FOLDER_STRUCTURE_DRAFT										(int) 4
     */
@Override public void onMapMessageDeletedEvent(java.lang.String address, java.lang.String handle, int type, int folder) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(handle);
_data.writeInt(type);
_data.writeInt(folder);
mRemote.transact(Stub.TRANSACTION_onMapMessageDeletedEvent, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onMapServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onMapStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_retMapDownloadedMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onMapNewMessageReceivedEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onMapDownloadNotify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_retMapDatabaseAvailable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_retMapDeleteDatabaseByAddressCompleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_retMapCleanDatabaseCompleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_retMapSendMessageCompleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_retMapDeleteMessageCompleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_retMapChangeReadStatusCompleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_onMapMemoryAvailableEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_onMapMessageSendingStatusEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_onMapMessageDeliverStatusEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_onMapMessageShiftedEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_onMapMessageDeletedEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
}
/** 
	 * Callback to inform MAP Service is ready.
	 */
public void onMapServiceReady() throws android.os.RemoteException;
/**
	 * Callback to inform change in MAP state of remote device with given Bluetooth hardware address.
	 * 
	 * The possible values of state in this profile are 
	 * 		<p><blockquote>STATE_NOT_INITIALIZED		(int) 100
	 * 		<br>STATE_READY								(int) 110
	 * 		<br>STATE_CONNECTED_REGISTERED				(int) 150
	 * 		<br>STATE_DOWNLOADING						(int) 160</blockquote>
	 * 
	 * On state STATE_NOT_INITIALIZED and STATE_READY, parameter address might contain unavailable content or 
	 * DEFAULT_ADDRESS , which is 00:00:00:00:00:00.
	 * STATE_CONNECTED implies the message downloading or database updating.
	 *
	 * @param address: Bluetooth MAC address of remote device which involves state changed. Only valid for states greater than STATE_READY.
	 * @param prevState: the previous state. 
	 * @param newState: the new state.
	 * @param reason: the reason of state changed. Possible values are
	 *		<br>MAP_REASON_NONE  											(int) 0
	 * 		<br>MAP_REASON_BAD_PARAMS  					                    (int) 1
	 * 		<br>MAP_REASON_DISCONNECT_FROM_LOCAL					        (int) 2
	 * 		<br>MAP_REASON_DISCONNECT_BY_PEER				                (int) 3	
	 * 		<br>MAP_REASON_INTERRUPT									    (int) 4
	 *		<br>MAP_REASON_DOWNLOAD_FINISH									(int) 5
 	 *		<br>MAP_REASON_PEER_NO_MAP_SERVICE								(int) 6
	 *		<br>MAP_REASON_TIMEOUT								            (int) 7
	 *		<br>MAP_REASON_DOWNLOAD_FAIL								    (int) 8
	 * Otherwise, the reason is -1.
     */
public void onMapStateChanged(java.lang.String address, int prevState, int newState, int reason) throws android.os.RemoteException;
/**
	 * Callback to inform response to {@link INfCallbackMap#reqMapDownloadAllMessages reqMapDownloadAllMessages} or
	 * {@link INfCallbackMap#reqMapDownloadSingleMessage reqMapDownloadSingleMessage}
	 * for remote connected device with given Bluetooth hardware address.
	 *
     * @param address Bluetooth MAC address of remote device.
     * @param handle MAP message handle, use this to download detail message. Change when disconnected.
     * @param senderName sender name.
     * @param senderNumber sender number.
     * @param recipientNumber recipient number.
     * @param date message receive date, ex: 20101010T101010Z means 2015/10/10 10:10:10
     * @param type message type.
     * @param folder which folder message download from. Possible values are
     *		<br>MAP_FOLDER_STRUCTURE_INBOX					(int) 0
	 * 		<br>MAP_FOLDER_STRUCTURE_SENT					(int) 1
	 * @param isReadStatus indicates the message is read (=true) or unread (=false).
     * @param subject message subject.
     * @param message message content.
     */
public void retMapDownloadedMessage(java.lang.String address, java.lang.String handle, java.lang.String senderName, java.lang.String senderNumber, java.lang.String recipientNumber, java.lang.String date, int type, int folder, boolean isReadStatus, java.lang.String subject, java.lang.String message) throws android.os.RemoteException;
/**
	 * Callback to inform the new message received on the remote device.
	 * This callback might be invocated due to {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification}.
	 * 
	 * If parameter downloadNewMessage of {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification} is 
	 * set to false, the parameter sender and message would be empty string.
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param handle MAP message handle.
     * @param sender Sender of the message. 
     * @param message Message content. 
     * The parameters "sender" and "message" are only available if parameter downloadNewMessage of {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification} is set to true. 
     */
public void onMapNewMessageReceivedEvent(java.lang.String address, java.lang.String handle, java.lang.String sender, java.lang.String message) throws android.os.RemoteException;
/**
	 * Callback to inform the specified number of messages have been downloaded from the remote device.
	 * 
	 * This callback might be invocated due to {@link INfCommandMap#setMapDownloadNotify setMapDownloadNotify} with 
	 * non-zero parameter notifyFreq set.
     * 
	 * @param address Bluetooth MAC address of remote device.
	 * @param folder which folder message download from. Possible values are
     *		<br>MAP_FOLDER_STRUCTURE_INBOX					(int) 0
	 * 		<br>MAP_FOLDER_STRUCTURE_SENT					(int) 1
	 * @param totalMessages total number of messages would be downloaded
	 * @param currentMessages the number of messages have been downloaded
     */
public void onMapDownloadNotify(java.lang.String address, int folder, int totalMessages, int currentMessages) throws android.os.RemoteException;
/**
	 * Callback to inform response to {@link INfCommandMap#reqMapDatabaseAvailable reqMapDatabaseAvailable}
	 * 
	 * When this callback is invocated, it means database is available.
	 *
     */
public void retMapDatabaseAvailable() throws android.os.RemoteException;
/**
     *  Callback to inform response to {@link INfCommandMap#reqMapDeleteDatabaseByAddress reqMapDeleteDatabaseByAddress}
     *
     *  @param address which address delete from table
     *  @param isSuccess means success or not
     */
public void retMapDeleteDatabaseByAddressCompleted(java.lang.String address, boolean isSuccess) throws android.os.RemoteException;
/**
	 * Callback to inform response to {@link INfCommandMap#reqMapCleanDatabase reqMapCleanDatabase}
	 * when database has been cleaned.
	 *
	 *  @param isSuccess means success or not
	 */
public void retMapCleanDatabaseCompleted(boolean isSuccess) throws android.os.RemoteException;
/**
	 * Callback to inform response to {@link INfCommandMap#reqMapSendMessage reqMapSendMessage}
	 *
	 *  @param address Bluetooth MAC address of remote device.
	 *  @param target phone number of target.
	 *  @param state Success or failed reason.
	 */
public void retMapSendMessageCompleted(java.lang.String address, java.lang.String target, int state) throws android.os.RemoteException;
/**
	 * Callback to inform response to {@link INfCommandMap#reqMapDeleteMessage reqMapDeleteMessage}
	 *
	 *  @param address Bluetooth MAC address of remote device.
	 *  @param handle MAP handle.
	 *  @param reason the reason of state changed. Possible values are
	 *		<br>REASON_SUCCESS											(int) 0
	 * 		<br>REASON_BAD_HANDLE										(int) 1
	 * 		<br>REASON_TIMEOUT											(int) 2
	 * 		<br>REASON_DELETE_FAIL										(int) 3
	 * Otherwise, the reason is -1.
	 */
public void retMapDeleteMessageCompleted(java.lang.String address, java.lang.String handle, int reason) throws android.os.RemoteException;
/**
	 * Callback to inform response to {@link INfCommandMap#reqChangeMapReadStatus reqChangeMapReadStatus}
	 *
	 * @param address Bluetooth MAC address of remote device.
	 * @param handle MAP handle.
	 * @param reason the reason of state changed. Possible values are
	 *		<br>REASON_SUCCESS											(int) 0
	 * 		<br>REASON_BAD_HANDLE										(int) 1
	 * 		<br>REASON_TIMEOUT											(int) 2
	 * 		<br>REASON_CHANGE_STATUS_FAIL								(int) 3
	 * Otherwise, the reason is -1.
	 */
public void retMapChangeReadStatusCompleted(java.lang.String address, java.lang.String handle, int reason) throws android.os.RemoteException;
/**
	 * Callback to inform the memory available on the remote device.
	 * This callback might be invocated due to {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification}.
	 * 
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param structure which folder is available. Possible values are
	 *		<br>MAP_FOLDER_STRUCTURE_INBOX										(int) 0
	 * 		<br>MAP_FOLDER_STRUCTURE_SENT										(int) 1
	 * 		<br>MAP_FOLDER_STRUCTURE_DELETED									(int) 2
	 * 		<br>MAP_FOLDER_STRUCTURE_OUTBOX										(int) 3
	 * 		<br>MAP_FOLDER_STRUCTURE_DRAFT										(int) 4
     * @param available true means memory available, and false means memory full.
     */
public void onMapMemoryAvailableEvent(java.lang.String address, int structure, boolean available) throws android.os.RemoteException;
/**
	 * Callback to inform the message sending status on the remote device.
	 * This callback might be invocated due to {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification}.
	 * 
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param handle MAP handle.
     * @param isSuccess sending success or not.
     */
public void onMapMessageSendingStatusEvent(java.lang.String address, java.lang.String handle, boolean isSuccess) throws android.os.RemoteException;
/**
	 * Callback to inform the message delivery status on the remote device.
	 * This callback might be invocated due to {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification}.
	 * 
	 *
	 * @param address Bluetooth MAC address of remote device.
     * @param handle MAP handle.
     * @param isSuccess deliver success or not
     */
public void onMapMessageDeliverStatusEvent(java.lang.String address, java.lang.String handle, boolean isSuccess) throws android.os.RemoteException;
/**
	 * Callback to inform the message shifted on the remote device.
	 * This callback might be invocated due to {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification}.
	 * 
	 *
	 * @param address Bluetooth MAC address of remote device.
	 * @param handle MAP handle.
     * @param type Possible values are
	 *		<br>MAP_TYPE_SMS_GSM										(int) 0
	 * 		<br>MAP_TYPE_SMS_CDMA										(int) 1
	 * 		<br>MAP_TYPE_SMS_MMS										(int) 2
	 * 		<br>MAP_TYPE_SMS_EMAIL										(int) 3
     * @param newFolder shift to which folder. Possible values are
	 *		<br>MAP_FOLDER_STRUCTURE_INBOX										(int) 0
	 * 		<br>MAP_FOLDER_STRUCTURE_SENT										(int) 1
	 * 		<br>MAP_FOLDER_STRUCTURE_DELETED									(int) 2
	 * 		<br>MAP_FOLDER_STRUCTURE_OUTBOX										(int) 3
	 * 		<br>MAP_FOLDER_STRUCTURE_DRAFT										(int) 4
	 * @param oldFolder shift from which folder. Possible values are
	 *		<br>MAP_FOLDER_STRUCTURE_INBOX										(int) 0
	 * 		<br>MAP_FOLDER_STRUCTURE_SENT										(int) 1
	 * 		<br>MAP_FOLDER_STRUCTURE_DELETED									(int) 2
	 * 		<br>MAP_FOLDER_STRUCTURE_OUTBOX										(int) 3
	 * 		<br>MAP_FOLDER_STRUCTURE_DRAFT										(int) 4
     */
public void onMapMessageShiftedEvent(java.lang.String address, java.lang.String handle, int type, int newFolder, int oldFolder) throws android.os.RemoteException;
/**
	 * Callback to inform the message deleted on the remote device.
	 * This callback might be invocated due to {@link INfCommandMap#reqMapRegisterNotification reqMapRegisterNotification}.
	 * 
	 *
	 * @param address Bluetooth MAC address of remote device.
	 * @param handle MAP handle.
     * @param type Possible values are
	 *		<br>MAP_TYPE_SMS_GSM										(int) 0
	 * 		<br>MAP_TYPE_SMS_CDMA										(int) 1
	 * 		<br>MAP_TYPE_SMS_MMS										(int) 2
	 * 		<br>MAP_TYPE_SMS_EMAIL										(int) 3
     * @param folder delete from which folder. Possible values are
	 *		<br>MAP_FOLDER_STRUCTURE_INBOX										(int) 0
	 * 		<br>MAP_FOLDER_STRUCTURE_SENT										(int) 1
	 * 		<br>MAP_FOLDER_STRUCTURE_DELETED									(int) 2
	 * 		<br>MAP_FOLDER_STRUCTURE_OUTBOX										(int) 3
	 * 		<br>MAP_FOLDER_STRUCTURE_DRAFT										(int) 4
     */
public void onMapMessageDeletedEvent(java.lang.String address, java.lang.String handle, int type, int folder) throws android.os.RemoteException;
}
