/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\LXS\\Desktop\\BtPhone\\src\\com\\nforetek\\bt\\aidl\\UiCallbackPbap.aidl
 */
package com.nforetek.bt.aidl;
/**
 * The callback interface for Phone Book Access Profile (PBAP).
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
 * @see INfCommandPbap
 */
public interface UiCallbackPbap extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.nforetek.bt.aidl.UiCallbackPbap
{
private static final java.lang.String DESCRIPTOR = "com.nforetek.bt.aidl.UiCallbackPbap";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.nforetek.bt.aidl.UiCallbackPbap interface,
 * generating a proxy if needed.
 */
public static com.nforetek.bt.aidl.UiCallbackPbap asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.nforetek.bt.aidl.UiCallbackPbap))) {
return ((com.nforetek.bt.aidl.UiCallbackPbap)iin);
}
return new com.nforetek.bt.aidl.UiCallbackPbap.Stub.Proxy(obj);
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
case TRANSACTION_onPbapServiceReady:
{
data.enforceInterface(DESCRIPTOR);
this.onPbapServiceReady();
reply.writeNoException();
return true;
}
case TRANSACTION_onPbapStateChanged:
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
this.onPbapStateChanged(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_retPbapDownloadedContact:
{
data.enforceInterface(DESCRIPTOR);
com.nforetek.bt.aidl.NfPbapContact _arg0;
if ((0!=data.readInt())) {
_arg0 = com.nforetek.bt.aidl.NfPbapContact.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.retPbapDownloadedContact(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_retPbapDownloadedCallLog:
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
int _arg5;
_arg5 = data.readInt();
java.lang.String _arg6;
_arg6 = data.readString();
this.retPbapDownloadedCallLog(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
reply.writeNoException();
return true;
}
case TRANSACTION_onPbapDownloadNotify:
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
this.onPbapDownloadNotify(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_retPbapDatabaseQueryNameByPartialNumber:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String[] _arg2;
_arg2 = data.createStringArray();
java.lang.String[] _arg3;
_arg3 = data.createStringArray();
boolean _arg4;
_arg4 = (0!=data.readInt());
this.retPbapDatabaseQueryNameByPartialNumber(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_retPbapDatabaseAvailable:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.retPbapDatabaseAvailable(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_retPbapDeleteDatabaseByAddressCompleted:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.retPbapDeleteDatabaseByAddressCompleted(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_retPbapCleanDatabaseCompleted:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.retPbapCleanDatabaseCompleted(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.nforetek.bt.aidl.UiCallbackPbap
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
	 * Callback to inform PBAP Service is ready.
	 */
@Override public void onPbapServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onPbapServiceReady, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform change in PBAP state of remote connected device with given Bluetooth hardware address.
	 * <p>The possible values of state in this profile are:
	 * 		<p><blockquote><b>STATE_NOT_INITIALIZED</b>		(int) 100
	 * 		<br><b>STATE_READY</b>							(int) 110
	 *		<br><b>STATE_DOWNLOADING</b>					(int) 140</blockquote>
	 * 
	 * <br>Parameter address is not valid for <b>STATE_NOT_INITIALIZED</b> and <b>STATE_READY</b>.
	 * <br>It might contain unavailable content or <b>DEFAULT_ADDRESS</b> , which is 00:00:00:00:00:00.
	 *
	 * @param address Bluetooth MAC address of remote device which involves state changed.
	 * @param prevState the previous state. 
	 * @param newState the new state.
	 * @param reason the reason of other states changed back to <b>STATE_READY</b>, which means download finished. Possible values are:
	 * 		<p><blockquote><b>REASON_DOWNLOAD_FULL_CONTENT_COMPLETED</b>	(int) 1
	 * 		<br><b>REASON_DOWNLOAD_FAILED</b>								(int) 2
	 * 		<br><b>REASON_DOWNLOAD_TIMEOUT</b>								(int) 3
	 * 		<br><b>REASON_DOWNLOAD_USER_REJECT</b>							(int) 4</blockquote>
	 * Otherwise, the reason is -1.
	 * @param counts the number of vCards downloaded or updated.
	 * This parameter is only available and meaningful when state changed from <b>STATE_DOWNLOADING</b> back to <b>STATE_READY</b>.
	 * Otherwise, the counts is -1.
     */
@Override public void onPbapStateChanged(java.lang.String address, int prevState, int newState, int reason, int counts) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(prevState);
_data.writeInt(newState);
_data.writeInt(reason);
_data.writeInt(counts);
mRemote.transact(Stub.TRANSACTION_onPbapStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapDownload reqPbapDownload}
	 * for remote connected device with given Bluetooth hardware address.
	 *
     * @param address Bluetooth MAC address of remote device.
     * @param firstName means first name of this contact.
     * @param middleName contact middle name.
     * @param lastName contact last name.
     * @param numbers numbers mean a number array of the total number of this contact.
     * @param types types mean a number type array of above numbers.
     * @param photoBytes mean a byte array of contact photo.
     * @param photoType possible photo type are:
     *		<blockquote><b>PBAP_PHOTO_TYPE_NULL</b>	(int) 0
	 *		<br><b>PBAP_PHOTO_TYPE_URI</b>			(int) 1
	 *		<br><b>PBAP_PHOTO_TYPE_URL</b>			(int) 2
	 *		<br><b>PBAP_PHOTO_TYPE_JPEG</b>			(int) 3
	 *		<br><b>PBAP_PHOTO_TYPE_GIF</b>			(int) 4</blockquote>
     */
@Override public void retPbapDownloadedContact(com.nforetek.bt.aidl.NfPbapContact contact) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((contact!=null)) {
_data.writeInt(1);
contact.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_retPbapDownloadedContact, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapDownload reqPbapDownload}
	 * for remote connected device with given Bluetooth hardware address.
	 *
     * @param address Bluetooth MAC address of remote device.
     * @param firstName means first name of this contact.
     * @param middleName contact middle name.
     * @param lastName contact last name.
     * @param number number mean the number of this call log.
     * @param type possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6</blockquote>	
     * @param timestamp call log timestamp ex: 20101010T101010Z means 2015/10/10 10:10:10
     */
@Override public void retPbapDownloadedCallLog(java.lang.String address, java.lang.String firstName, java.lang.String middleName, java.lang.String lastName, java.lang.String number, int type, java.lang.String timestamp) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(firstName);
_data.writeString(middleName);
_data.writeString(lastName);
_data.writeString(number);
_data.writeInt(type);
_data.writeString(timestamp);
mRemote.transact(Stub.TRANSACTION_retPbapDownloadedCallLog, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform the specified number of vcards have been downloaded from the remote device and save to local database.
	 * 
	 * This callback might be invocated due to 
	 * {@link INfCommandPbap#reqPbapDownload reqPbapDownload}, 
	 * {@link INfCommandPbap#reqPbapDownloadRange reqPbapDownloadRange},
	 * {@link INfCommandPbap#reqPbapDownloadToDatabase reqPbapDownloadToDatabase},
	 * {@link INfCommandPbap#reqPbapDownloadRangeToDatabase reqPbapDownloadRangeToDatabase},
	 * {@link INfCommandPbap#reqPbapDownloadToContactsProvider reqPbapDownloadToContactsProvider} or 
	 * {@link INfCommandPbap#reqPbapDownloadRangeToContactsProvider reqPbapDownloadRangeToContactsProvider}  
	 * and {@link INfCommandPbap#setPbapDownloadNotify setPbapDownloadNotify} with non-zero parameter frequency set.
     * 
	 * @param address Bluetooth MAC address of remote device.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6</blockquote>	
	 * @param totalContacts total number of contacts would be downloaded. If not support, number will be zero.
	 * @param downloadedContacts the number of contacts have been downloaded
     */
@Override public void onPbapDownloadNotify(java.lang.String address, int storage, int totalContacts, int downloadedContacts) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(storage);
_data.writeInt(totalContacts);
_data.writeInt(downloadedContacts);
mRemote.transact(Stub.TRANSACTION_onPbapDownloadNotify, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
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
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapDatabaseQueryNameByPartialNumber reqPbapDatabaseQueryNameByPartialNumber}
	 * for remote connected device with given Bluetooth hardware address.
	 *
     * @param address Bluetooth MAC address of remote device.
     * @param target the queried phone number.     
     * @param names the corresponding name of specified phone name array. This name is meaningful only if isSuccessed is true.
     * @param numbers the corresponding number of specified phone number array. This number is meaningful only if isSuccessed is true.
     * @param isSuccess indicates that if the corresponding name is retrieved. 
     */
@Override public void retPbapDatabaseQueryNameByPartialNumber(java.lang.String address, java.lang.String target, java.lang.String[] names, java.lang.String[] numbers, boolean isSuccess) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeString(target);
_data.writeStringArray(names);
_data.writeStringArray(numbers);
_data.writeInt(((isSuccess)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_retPbapDatabaseQueryNameByPartialNumber, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapDatabaseAvailable reqPbapDatabaseAvailable}
	 * for remote connected device.
	 * <p>When this callback is invocated, it means nFore's PBAP database is available for query.
	 * 
	 * <p>When nFore's PBAP database is required to access, this command has to be issued in advanced and wait for 
	 * the callback {@link INfCallbackPbap#retPbapDatabaseAvailable retPbapDatabaseAvailable}. Or the database may be crashed!
	 * <br>After nFore's PBAP database is done accessing, the database resource needs to be released. And should <b>never</b> use commands
	 * {@link INfCommandPbap#reqPbapDownloadToDatabase reqPbapDownloadToDatabase}, 
	 * {@link INfCommandPbap#reqPbapDownloadToContactsProvider reqPbapDownloadToContactsProvider},
	 * {@link INfCommandPbap#reqPbapDatabaseQueryNameByNumber reqPbapDatabaseQueryNameByNumber} or 
	 * {@link INfCommandPbap#reqPbapDatabaseQueryNameByPartialNumber reqPbapDatabaseQueryNameByPartialNumber} 
	 * before the database resource is released. 
	 *
	 * @param address Bluetooth MAC address of remote device.
     */
@Override public void retPbapDatabaseAvailable(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_retPbapDatabaseAvailable, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapDeleteDatabaseByAddress reqPbapDeleteDatabaseByAddress}
	 * when database has been deleted.
	 *
	 * @param address Bluetooth MAC address of remote device which just completed deleted 
	 * @param isSuccess indicate that if deletion is completed successfully, or false erroneous.
	 */
@Override public void retPbapDeleteDatabaseByAddressCompleted(java.lang.String address, boolean isSuccess) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(((isSuccess)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_retPbapDeleteDatabaseByAddressCompleted, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapCleanDatabase reqPbapCleanDatabase}
	 * when database has been cleaned.
	 *
	 * @param isSuccess indicate that if database is cleaned successfully, or false erroneous.
	 */
@Override public void retPbapCleanDatabaseCompleted(boolean isSuccess) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isSuccess)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_retPbapCleanDatabaseCompleted, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onPbapServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onPbapStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_retPbapDownloadedContact = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_retPbapDownloadedCallLog = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onPbapDownloadNotify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_retPbapDatabaseQueryNameByNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_retPbapDatabaseQueryNameByPartialNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_retPbapDatabaseAvailable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_retPbapDeleteDatabaseByAddressCompleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_retPbapCleanDatabaseCompleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
}
/** 
	 * Callback to inform PBAP Service is ready.
	 */
public void onPbapServiceReady() throws android.os.RemoteException;
/**
	 * Callback to inform change in PBAP state of remote connected device with given Bluetooth hardware address.
	 * <p>The possible values of state in this profile are:
	 * 		<p><blockquote><b>STATE_NOT_INITIALIZED</b>		(int) 100
	 * 		<br><b>STATE_READY</b>							(int) 110
	 *		<br><b>STATE_DOWNLOADING</b>					(int) 140</blockquote>
	 * 
	 * <br>Parameter address is not valid for <b>STATE_NOT_INITIALIZED</b> and <b>STATE_READY</b>.
	 * <br>It might contain unavailable content or <b>DEFAULT_ADDRESS</b> , which is 00:00:00:00:00:00.
	 *
	 * @param address Bluetooth MAC address of remote device which involves state changed.
	 * @param prevState the previous state. 
	 * @param newState the new state.
	 * @param reason the reason of other states changed back to <b>STATE_READY</b>, which means download finished. Possible values are:
	 * 		<p><blockquote><b>REASON_DOWNLOAD_FULL_CONTENT_COMPLETED</b>	(int) 1
	 * 		<br><b>REASON_DOWNLOAD_FAILED</b>								(int) 2
	 * 		<br><b>REASON_DOWNLOAD_TIMEOUT</b>								(int) 3
	 * 		<br><b>REASON_DOWNLOAD_USER_REJECT</b>							(int) 4</blockquote>
	 * Otherwise, the reason is -1.
	 * @param counts the number of vCards downloaded or updated.
	 * This parameter is only available and meaningful when state changed from <b>STATE_DOWNLOADING</b> back to <b>STATE_READY</b>.
	 * Otherwise, the counts is -1.
     */
public void onPbapStateChanged(java.lang.String address, int prevState, int newState, int reason, int counts) throws android.os.RemoteException;
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapDownload reqPbapDownload}
	 * for remote connected device with given Bluetooth hardware address.
	 *
     * @param address Bluetooth MAC address of remote device.
     * @param firstName means first name of this contact.
     * @param middleName contact middle name.
     * @param lastName contact last name.
     * @param numbers numbers mean a number array of the total number of this contact.
     * @param types types mean a number type array of above numbers.
     * @param photoBytes mean a byte array of contact photo.
     * @param photoType possible photo type are:
     *		<blockquote><b>PBAP_PHOTO_TYPE_NULL</b>	(int) 0
	 *		<br><b>PBAP_PHOTO_TYPE_URI</b>			(int) 1
	 *		<br><b>PBAP_PHOTO_TYPE_URL</b>			(int) 2
	 *		<br><b>PBAP_PHOTO_TYPE_JPEG</b>			(int) 3
	 *		<br><b>PBAP_PHOTO_TYPE_GIF</b>			(int) 4</blockquote>
     */
public void retPbapDownloadedContact(com.nforetek.bt.aidl.NfPbapContact contact) throws android.os.RemoteException;
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapDownload reqPbapDownload}
	 * for remote connected device with given Bluetooth hardware address.
	 *
     * @param address Bluetooth MAC address of remote device.
     * @param firstName means first name of this contact.
     * @param middleName contact middle name.
     * @param lastName contact last name.
     * @param number number mean the number of this call log.
     * @param type possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6</blockquote>	
     * @param timestamp call log timestamp ex: 20101010T101010Z means 2015/10/10 10:10:10
     */
public void retPbapDownloadedCallLog(java.lang.String address, java.lang.String firstName, java.lang.String middleName, java.lang.String lastName, java.lang.String number, int type, java.lang.String timestamp) throws android.os.RemoteException;
/**
	 * Callback to inform the specified number of vcards have been downloaded from the remote device and save to local database.
	 * 
	 * This callback might be invocated due to 
	 * {@link INfCommandPbap#reqPbapDownload reqPbapDownload}, 
	 * {@link INfCommandPbap#reqPbapDownloadRange reqPbapDownloadRange},
	 * {@link INfCommandPbap#reqPbapDownloadToDatabase reqPbapDownloadToDatabase},
	 * {@link INfCommandPbap#reqPbapDownloadRangeToDatabase reqPbapDownloadRangeToDatabase},
	 * {@link INfCommandPbap#reqPbapDownloadToContactsProvider reqPbapDownloadToContactsProvider} or 
	 * {@link INfCommandPbap#reqPbapDownloadRangeToContactsProvider reqPbapDownloadRangeToContactsProvider}  
	 * and {@link INfCommandPbap#setPbapDownloadNotify setPbapDownloadNotify} with non-zero parameter frequency set.
     * 
	 * @param address Bluetooth MAC address of remote device.
	 * @param storage possible storage type are:
	 *		<blockquote><b>PBAP_STORAGE_SIM</b>			(int) 1
	 *		<br><b>PBAP_STORAGE_PHONE_MEMORY</b>		(int) 2
	 *		<br><b>PBAP_STORAGE_MISSED_CALLS</b>		(int) 3
	 *		<br><b>PBAP_STORAGE_RECEIVED_CALLS</b>		(int) 4
	 *		<br><b>PBAP_STORAGE_DIALED_CALLS</b>		(int) 5
	 *		<br><b>PBAP_STORAGE_CALL_LOGS</b>			(int) 6</blockquote>	
	 * @param totalContacts total number of contacts would be downloaded. If not support, number will be zero.
	 * @param downloadedContacts the number of contacts have been downloaded
     */
public void onPbapDownloadNotify(java.lang.String address, int storage, int totalContacts, int downloadedContacts) throws android.os.RemoteException;
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
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapDatabaseQueryNameByPartialNumber reqPbapDatabaseQueryNameByPartialNumber}
	 * for remote connected device with given Bluetooth hardware address.
	 *
     * @param address Bluetooth MAC address of remote device.
     * @param target the queried phone number.     
     * @param names the corresponding name of specified phone name array. This name is meaningful only if isSuccessed is true.
     * @param numbers the corresponding number of specified phone number array. This number is meaningful only if isSuccessed is true.
     * @param isSuccess indicates that if the corresponding name is retrieved. 
     */
public void retPbapDatabaseQueryNameByPartialNumber(java.lang.String address, java.lang.String target, java.lang.String[] names, java.lang.String[] numbers, boolean isSuccess) throws android.os.RemoteException;
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapDatabaseAvailable reqPbapDatabaseAvailable}
	 * for remote connected device.
	 * <p>When this callback is invocated, it means nFore's PBAP database is available for query.
	 * 
	 * <p>When nFore's PBAP database is required to access, this command has to be issued in advanced and wait for 
	 * the callback {@link INfCallbackPbap#retPbapDatabaseAvailable retPbapDatabaseAvailable}. Or the database may be crashed!
	 * <br>After nFore's PBAP database is done accessing, the database resource needs to be released. And should <b>never</b> use commands
	 * {@link INfCommandPbap#reqPbapDownloadToDatabase reqPbapDownloadToDatabase}, 
	 * {@link INfCommandPbap#reqPbapDownloadToContactsProvider reqPbapDownloadToContactsProvider},
	 * {@link INfCommandPbap#reqPbapDatabaseQueryNameByNumber reqPbapDatabaseQueryNameByNumber} or 
	 * {@link INfCommandPbap#reqPbapDatabaseQueryNameByPartialNumber reqPbapDatabaseQueryNameByPartialNumber} 
	 * before the database resource is released. 
	 *
	 * @param address Bluetooth MAC address of remote device.
     */
public void retPbapDatabaseAvailable(java.lang.String address) throws android.os.RemoteException;
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapDeleteDatabaseByAddress reqPbapDeleteDatabaseByAddress}
	 * when database has been deleted.
	 *
	 * @param address Bluetooth MAC address of remote device which just completed deleted 
	 * @param isSuccess indicate that if deletion is completed successfully, or false erroneous.
	 */
public void retPbapDeleteDatabaseByAddressCompleted(java.lang.String address, boolean isSuccess) throws android.os.RemoteException;
/**
	 * Callback to inform response to {@link INfCommandPbap#reqPbapCleanDatabase reqPbapCleanDatabase}
	 * when database has been cleaned.
	 *
	 * @param isSuccess indicate that if database is cleaned successfully, or false erroneous.
	 */
public void retPbapCleanDatabaseCompleted(boolean isSuccess) throws android.os.RemoteException;
}
