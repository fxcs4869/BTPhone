/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\LXS\\Desktop\\BtPhone\\src\\com\\nforetek\\bt\\aidl\\UiCallbackGattServer.aidl
 */
package com.nforetek.bt.aidl;
/**
 * The callback interface for Gatt Server (BLE Peripheral)
 * <br>UI program should implement all methods of this interface 
 * for receiving possible callbacks from nFore service.
 * <br>The naming principle of callback in this Doc is as below,
 *      <blockquote>    <b>retXXX()</b> : must be the callback of requested API.
 *      <br>            <b>onXXX()</b>  : could be the callback for updated values or the callback from requested API.</blockquote>
 *
 * <p> The constant variables in this Doc could be found and referred by importing
 *      <br><blockquote>com.nforetek.bt.res.NfDef</blockquote>
 * <p> with prefix NfDef class name. Ex : <code>NfDef.DEFAULT_ADDRESS</code>
 *
 * <p> Bluetooth hardware addresses would be in a format such as "00:11:22:33:AA:BB".
 *
 * @see UiCommand
 */
public interface UiCallbackGattServer extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.nforetek.bt.aidl.UiCallbackGattServer
{
private static final java.lang.String DESCRIPTOR = "com.nforetek.bt.aidl.UiCallbackGattServer";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.nforetek.bt.aidl.UiCallbackGattServer interface,
 * generating a proxy if needed.
 */
public static com.nforetek.bt.aidl.UiCallbackGattServer asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.nforetek.bt.aidl.UiCallbackGattServer))) {
return ((com.nforetek.bt.aidl.UiCallbackGattServer)iin);
}
return new com.nforetek.bt.aidl.UiCallbackGattServer.Stub.Proxy(obj);
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
case TRANSACTION_onGattServiceReady:
{
data.enforceInterface(DESCRIPTOR);
this.onGattServiceReady();
reply.writeNoException();
return true;
}
case TRANSACTION_onGattServerStateChanged:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.onGattServerStateChanged(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onGattServerServiceAdded:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.os.ParcelUuid _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.onGattServerServiceAdded(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onGattServerServiceDeleted:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.os.ParcelUuid _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.onGattServerServiceDeleted(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onGattServerCharacteristicReadRequest:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
boolean _arg3;
_arg3 = (0!=data.readInt());
int _arg4;
_arg4 = data.readInt();
android.os.ParcelUuid _arg5;
if ((0!=data.readInt())) {
_arg5 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
android.os.ParcelUuid _arg6;
if ((0!=data.readInt())) {
_arg6 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg6 = null;
}
this.onGattServerCharacteristicReadRequest(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
reply.writeNoException();
return true;
}
case TRANSACTION_onGattServerCharacteristicWriteRequest:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
boolean _arg3;
_arg3 = (0!=data.readInt());
boolean _arg4;
_arg4 = (0!=data.readInt());
int _arg5;
_arg5 = data.readInt();
android.os.ParcelUuid _arg6;
if ((0!=data.readInt())) {
_arg6 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg6 = null;
}
android.os.ParcelUuid _arg7;
if ((0!=data.readInt())) {
_arg7 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg7 = null;
}
byte[] _arg8;
_arg8 = data.createByteArray();
this.onGattServerCharacteristicWriteRequest(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8);
reply.writeNoException();
return true;
}
case TRANSACTION_onGattServerDescriptorReadRequest:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
boolean _arg3;
_arg3 = (0!=data.readInt());
int _arg4;
_arg4 = data.readInt();
android.os.ParcelUuid _arg5;
if ((0!=data.readInt())) {
_arg5 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
android.os.ParcelUuid _arg6;
if ((0!=data.readInt())) {
_arg6 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg6 = null;
}
android.os.ParcelUuid _arg7;
if ((0!=data.readInt())) {
_arg7 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg7 = null;
}
this.onGattServerDescriptorReadRequest(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
reply.writeNoException();
return true;
}
case TRANSACTION_onGattServerDescriptorWriteRequest:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
boolean _arg3;
_arg3 = (0!=data.readInt());
boolean _arg4;
_arg4 = (0!=data.readInt());
int _arg5;
_arg5 = data.readInt();
android.os.ParcelUuid _arg6;
if ((0!=data.readInt())) {
_arg6 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg6 = null;
}
android.os.ParcelUuid _arg7;
if ((0!=data.readInt())) {
_arg7 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg7 = null;
}
android.os.ParcelUuid _arg8;
if ((0!=data.readInt())) {
_arg8 = android.os.ParcelUuid.CREATOR.createFromParcel(data);
}
else {
_arg8 = null;
}
byte[] _arg9;
_arg9 = data.createByteArray();
this.onGattServerDescriptorWriteRequest(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9);
reply.writeNoException();
return true;
}
case TRANSACTION_onGattServerExecuteWrite:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _arg2;
_arg2 = (0!=data.readInt());
this.onGattServerExecuteWrite(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.nforetek.bt.aidl.UiCallbackGattServer
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
     * Callback to inform Gatt Server Service is ready.
     */
@Override public void onGattServiceReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onGattServiceReady, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
     * Callback to inform state change of Gatt server connected remote device.
     * <p>The possible values of state in this callback are 
     *      <blockquote><b>STATE_NOT_INITIALIZED</b>        (int) 100
     *      <br><b>STATE_READY</b>                          (int) 110
     *      <br><b>STATE_LISTENING</b>                       (int) 130
     *      <br><b>STATE_CONNECTED</b>                      (int) 140</blockquote>
     *
     * <br>Parameter address is not valid for <b>STATE_NOT_INITIALIZED</b>, <b>STATE_READY</b> and <b>STATE_LISTENING</b>.
     * <br>It might contain unavailable content or <b>DEFAULT_ADDRESS</b> , which is 00:00:00:00:00:00.
     *
     * @param address Bluetooth MAC address of remote device which involves state changed.
     * @param state the new state.
     */
@Override public void onGattServerStateChanged(java.lang.String address, int state) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(state);
mRemote.transact(Stub.TRANSACTION_onGattServerStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
     * Callback to inform service added successfully in Gatt server.    
     *
     * @param status Returns GATT_SUCCESS (0) if the service
     *               was added successfully.
     * @param srvcType service type
     * @param srvcUuid The service UUID that has been added
     */
@Override public void onGattServerServiceAdded(int status, int srvcType, android.os.ParcelUuid srvcUuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
_data.writeInt(srvcType);
if ((srvcUuid!=null)) {
_data.writeInt(1);
srvcUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onGattServerServiceAdded, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
     * Callback to inform service deleted successfully in Gatt server.    
     *
     * @param status Returns GATT_SUCCESS (0) if the service
     *               was deleted successfully.
     * @param srvcType service type
     * @param srvcUuid The service UUID that has been deleted.
     */
@Override public void onGattServerServiceDeleted(int status, int srvcType, android.os.ParcelUuid srvcUuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
_data.writeInt(srvcType);
if ((srvcUuid!=null)) {
_data.writeInt(1);
srvcUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onGattServerServiceDeleted, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
     * A remote client has requested to read a local characteristic.
     * Callback to inform Gatt Client requests to read characteristic. Send Response is required.    
     *
     * <p>An application must call {@link INfCommandGattServer#reqGattServerSendResponse reqGattServerSendResponse}
     * to complete the request.
     *
     * @param address Bluetooth MAC address of remote device
     * @param requestId The ID of the request
     * @param offset Offset into the value of the characteristic
     * @param isLong true if have multiple read request
     * @param srvcType service type
     * @param srvcUuid sevice UUID
     * @param charUuid Characteristic UUID to be read
     */
@Override public void onGattServerCharacteristicReadRequest(java.lang.String address, int requestId, int offset, boolean isLong, int srvcType, android.os.ParcelUuid srvcUuid, android.os.ParcelUuid charUuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(requestId);
_data.writeInt(offset);
_data.writeInt(((isLong)?(1):(0)));
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
mRemote.transact(Stub.TRANSACTION_onGattServerCharacteristicReadRequest, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
     * A remote client has requested to write to a local characteristic.
     * Callback to inform Gatt Client requests to write characteristic. Send Response is required
     * or not depends on responseNeeded.
     *
     * <p>An application must call {@link INfCommandGattServer#reqGattServerSendResponse reqGattServerSendResponse}
     * to complete the request.
     *
     * @param address Bluetooth MAC address of remote device
     * @param requestId The ID of the request
     * @param offset Value offset for partial request
     * @param preparedWrite true if this write operation should be queued for
     *                      later execution.
     * @param responseNeeded true if the remote device requires a response
     * @param srvcType Service type
     * @param srvcUuid Service UUID
     * @param charUuid Characteristic UUID to be written to.
     * @param value The value the client wants to assign to the characteristic
     */
@Override public void onGattServerCharacteristicWriteRequest(java.lang.String address, int requestId, int offset, boolean preparedWrite, boolean responseNeeded, int srvcType, android.os.ParcelUuid srvcUuid, android.os.ParcelUuid charUuid, byte[] value) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(requestId);
_data.writeInt(offset);
_data.writeInt(((preparedWrite)?(1):(0)));
_data.writeInt(((responseNeeded)?(1):(0)));
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
_data.writeByteArray(value);
mRemote.transact(Stub.TRANSACTION_onGattServerCharacteristicWriteRequest, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
     * A remote client has requested to read a local descriptor.
     * Callback to inform Gatt Client requests to read characteristic descriptor. Send Response is required.    
     *
     * <p>An application must call {@link INfCommandGattServer#reqGattServerSendResponse reqGattServerSendResponse}
     * to complete the request.
     *
     * @param address Bluetooth MAC address of remote device
     * @param requestId The ID of the request
     * @param offset Offset into the value of the descriptor
     * @param isLong true if have multiple read request
     * @param srvcType Service type
     * @param srvcUuid Service UUID
     * @param charUuid Characteristic UUID
     * @param descrUuid Descriptor UUID
     */
@Override public void onGattServerDescriptorReadRequest(java.lang.String address, int requestId, int offset, boolean isLong, int srvcType, android.os.ParcelUuid srvcUuid, android.os.ParcelUuid charUuid, android.os.ParcelUuid descrUuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(requestId);
_data.writeInt(offset);
_data.writeInt(((isLong)?(1):(0)));
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
if ((descrUuid!=null)) {
_data.writeInt(1);
descrUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onGattServerDescriptorReadRequest, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
     * A remote client has requested to write to a local descriptor.
     * Callback to inform Gatt Client requests to write characteristic descriptor. Send Response is required
     * or not depends on responseNeeded.
     *
     * <p>An application must call {@link INfCommandGattServer#reqGattServerSendResponse reqGattServerSendResponse}
     * to complete the request.
     *
     * @param address Bluetooth MAC address of remote device
     * @param requestId The ID of the request
     * @param offset The offset given for the value
     * @param preparedWrite true, if this write operation should be queued for
     *                      later execution.
     * @param responseNeeded true, if the remote device requires a response
     * @param srvcType Service type
     * @param srvcUuid Service UUID
     * @param charUuid Characteristic UUID
     * @param descrUuid Descriptor UUID to be written to.
     * @param value The value the client wants to assign to the descriptor
     */
@Override public void onGattServerDescriptorWriteRequest(java.lang.String address, int requestId, int offset, boolean isPrep, boolean responseNeeded, int srvcType, android.os.ParcelUuid srvcUuid, android.os.ParcelUuid charUuid, android.os.ParcelUuid descrUuid, byte[] value) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(requestId);
_data.writeInt(offset);
_data.writeInt(((isPrep)?(1):(0)));
_data.writeInt(((responseNeeded)?(1):(0)));
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
if ((descrUuid!=null)) {
_data.writeInt(1);
descrUuid.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeByteArray(value);
mRemote.transact(Stub.TRANSACTION_onGattServerDescriptorWriteRequest, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** 
     * Execute all pending write operations for this device.
     * Callback to inform Gatt Client write request finishes only if multiple write requests are issued.
     *
     * <p>An application must call {@link INfCommandGattServer#reqGattServerSendResponse reqGattServerSendResponse}
     * to complete the request.
     *
     * @param address Bluetooth MAC address of remote device
     * @param requestId The ID of the request
     * @param execute Whether the pending writes should be executed (true) or
     *                cancelled (false)
     */
@Override public void onGattServerExecuteWrite(java.lang.String address, int requestId, boolean execute) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
_data.writeInt(requestId);
_data.writeInt(((execute)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onGattServerExecuteWrite, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onGattServiceReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onGattServerStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onGattServerServiceAdded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onGattServerServiceDeleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onGattServerCharacteristicReadRequest = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_onGattServerCharacteristicWriteRequest = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_onGattServerDescriptorReadRequest = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_onGattServerDescriptorWriteRequest = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_onGattServerExecuteWrite = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
}
/** 
     * Callback to inform Gatt Server Service is ready.
     */
public void onGattServiceReady() throws android.os.RemoteException;
/** 
     * Callback to inform state change of Gatt server connected remote device.
     * <p>The possible values of state in this callback are 
     *      <blockquote><b>STATE_NOT_INITIALIZED</b>        (int) 100
     *      <br><b>STATE_READY</b>                          (int) 110
     *      <br><b>STATE_LISTENING</b>                       (int) 130
     *      <br><b>STATE_CONNECTED</b>                      (int) 140</blockquote>
     *
     * <br>Parameter address is not valid for <b>STATE_NOT_INITIALIZED</b>, <b>STATE_READY</b> and <b>STATE_LISTENING</b>.
     * <br>It might contain unavailable content or <b>DEFAULT_ADDRESS</b> , which is 00:00:00:00:00:00.
     *
     * @param address Bluetooth MAC address of remote device which involves state changed.
     * @param state the new state.
     */
public void onGattServerStateChanged(java.lang.String address, int state) throws android.os.RemoteException;
/** 
     * Callback to inform service added successfully in Gatt server.    
     *
     * @param status Returns GATT_SUCCESS (0) if the service
     *               was added successfully.
     * @param srvcType service type
     * @param srvcUuid The service UUID that has been added
     */
public void onGattServerServiceAdded(int status, int srvcType, android.os.ParcelUuid srvcUuid) throws android.os.RemoteException;
/** 
     * Callback to inform service deleted successfully in Gatt server.    
     *
     * @param status Returns GATT_SUCCESS (0) if the service
     *               was deleted successfully.
     * @param srvcType service type
     * @param srvcUuid The service UUID that has been deleted.
     */
public void onGattServerServiceDeleted(int status, int srvcType, android.os.ParcelUuid srvcUuid) throws android.os.RemoteException;
/** 
     * A remote client has requested to read a local characteristic.
     * Callback to inform Gatt Client requests to read characteristic. Send Response is required.    
     *
     * <p>An application must call {@link INfCommandGattServer#reqGattServerSendResponse reqGattServerSendResponse}
     * to complete the request.
     *
     * @param address Bluetooth MAC address of remote device
     * @param requestId The ID of the request
     * @param offset Offset into the value of the characteristic
     * @param isLong true if have multiple read request
     * @param srvcType service type
     * @param srvcUuid sevice UUID
     * @param charUuid Characteristic UUID to be read
     */
public void onGattServerCharacteristicReadRequest(java.lang.String address, int requestId, int offset, boolean isLong, int srvcType, android.os.ParcelUuid srvcUuid, android.os.ParcelUuid charUuid) throws android.os.RemoteException;
/** 
     * A remote client has requested to write to a local characteristic.
     * Callback to inform Gatt Client requests to write characteristic. Send Response is required
     * or not depends on responseNeeded.
     *
     * <p>An application must call {@link INfCommandGattServer#reqGattServerSendResponse reqGattServerSendResponse}
     * to complete the request.
     *
     * @param address Bluetooth MAC address of remote device
     * @param requestId The ID of the request
     * @param offset Value offset for partial request
     * @param preparedWrite true if this write operation should be queued for
     *                      later execution.
     * @param responseNeeded true if the remote device requires a response
     * @param srvcType Service type
     * @param srvcUuid Service UUID
     * @param charUuid Characteristic UUID to be written to.
     * @param value The value the client wants to assign to the characteristic
     */
public void onGattServerCharacteristicWriteRequest(java.lang.String address, int requestId, int offset, boolean preparedWrite, boolean responseNeeded, int srvcType, android.os.ParcelUuid srvcUuid, android.os.ParcelUuid charUuid, byte[] value) throws android.os.RemoteException;
/** 
     * A remote client has requested to read a local descriptor.
     * Callback to inform Gatt Client requests to read characteristic descriptor. Send Response is required.    
     *
     * <p>An application must call {@link INfCommandGattServer#reqGattServerSendResponse reqGattServerSendResponse}
     * to complete the request.
     *
     * @param address Bluetooth MAC address of remote device
     * @param requestId The ID of the request
     * @param offset Offset into the value of the descriptor
     * @param isLong true if have multiple read request
     * @param srvcType Service type
     * @param srvcUuid Service UUID
     * @param charUuid Characteristic UUID
     * @param descrUuid Descriptor UUID
     */
public void onGattServerDescriptorReadRequest(java.lang.String address, int requestId, int offset, boolean isLong, int srvcType, android.os.ParcelUuid srvcUuid, android.os.ParcelUuid charUuid, android.os.ParcelUuid descrUuid) throws android.os.RemoteException;
/** 
     * A remote client has requested to write to a local descriptor.
     * Callback to inform Gatt Client requests to write characteristic descriptor. Send Response is required
     * or not depends on responseNeeded.
     *
     * <p>An application must call {@link INfCommandGattServer#reqGattServerSendResponse reqGattServerSendResponse}
     * to complete the request.
     *
     * @param address Bluetooth MAC address of remote device
     * @param requestId The ID of the request
     * @param offset The offset given for the value
     * @param preparedWrite true, if this write operation should be queued for
     *                      later execution.
     * @param responseNeeded true, if the remote device requires a response
     * @param srvcType Service type
     * @param srvcUuid Service UUID
     * @param charUuid Characteristic UUID
     * @param descrUuid Descriptor UUID to be written to.
     * @param value The value the client wants to assign to the descriptor
     */
public void onGattServerDescriptorWriteRequest(java.lang.String address, int requestId, int offset, boolean isPrep, boolean responseNeeded, int srvcType, android.os.ParcelUuid srvcUuid, android.os.ParcelUuid charUuid, android.os.ParcelUuid descrUuid, byte[] value) throws android.os.RemoteException;
/** 
     * Execute all pending write operations for this device.
     * Callback to inform Gatt Client write request finishes only if multiple write requests are issued.
     *
     * <p>An application must call {@link INfCommandGattServer#reqGattServerSendResponse reqGattServerSendResponse}
     * to complete the request.
     *
     * @param address Bluetooth MAC address of remote device
     * @param requestId The ID of the request
     * @param execute Whether the pending writes should be executed (true) or
     *                cancelled (false)
     */
public void onGattServerExecuteWrite(java.lang.String address, int requestId, boolean execute) throws android.os.RemoteException;
}
