/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package woyou.aidlservice.jiuiv5;
public interface IWoyouService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements woyou.aidlservice.jiuiv5.IWoyouService
{
private static final java.lang.String DESCRIPTOR = "woyou.aidlservice.jiuiv5.IWoyouService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an woyou.aidlservice.jiuiv5.IWoyouService interface,
 * generating a proxy if needed.
 */
public static woyou.aidlservice.jiuiv5.IWoyouService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof woyou.aidlservice.jiuiv5.IWoyouService))) {
return ((woyou.aidlservice.jiuiv5.IWoyouService)iin);
}
return new woyou.aidlservice.jiuiv5.IWoyouService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
java.lang.String descriptor = DESCRIPTOR;
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(descriptor);
return true;
}
case TRANSACTION_updateFirmware:
{
data.enforceInterface(descriptor);
this.updateFirmware();
reply.writeNoException();
return true;
}
case TRANSACTION_getFirmwareStatus:
{
data.enforceInterface(descriptor);
int _result = this.getFirmwareStatus();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getServiceVersion:
{
data.enforceInterface(descriptor);
java.lang.String _result = this.getServiceVersion();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_printerInit:
{
data.enforceInterface(descriptor);
woyou.aidlservice.jiuiv5.ICallback _arg0;
_arg0 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.printerInit(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_printerSelfChecking:
{
data.enforceInterface(descriptor);
woyou.aidlservice.jiuiv5.ICallback _arg0;
_arg0 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.printerSelfChecking(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getPrinterSerialNo:
{
data.enforceInterface(descriptor);
java.lang.String _result = this.getPrinterSerialNo();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getPrinterVersion:
{
data.enforceInterface(descriptor);
java.lang.String _result = this.getPrinterVersion();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getPrinterModal:
{
data.enforceInterface(descriptor);
java.lang.String _result = this.getPrinterModal();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getPrintedLength:
{
data.enforceInterface(descriptor);
woyou.aidlservice.jiuiv5.ICallback _arg0;
_arg0 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.getPrintedLength(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_lineWrap:
{
data.enforceInterface(descriptor);
int _arg0;
_arg0 = data.readInt();
woyou.aidlservice.jiuiv5.ICallback _arg1;
_arg1 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.lineWrap(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_sendRAWData:
{
data.enforceInterface(descriptor);
byte[] _arg0;
_arg0 = data.createByteArray();
woyou.aidlservice.jiuiv5.ICallback _arg1;
_arg1 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.sendRAWData(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setAlignment:
{
data.enforceInterface(descriptor);
int _arg0;
_arg0 = data.readInt();
woyou.aidlservice.jiuiv5.ICallback _arg1;
_arg1 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.setAlignment(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setFontName:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
woyou.aidlservice.jiuiv5.ICallback _arg1;
_arg1 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.setFontName(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setFontSize:
{
data.enforceInterface(descriptor);
float _arg0;
_arg0 = data.readFloat();
woyou.aidlservice.jiuiv5.ICallback _arg1;
_arg1 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.setFontSize(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_printText:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
woyou.aidlservice.jiuiv5.ICallback _arg1;
_arg1 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.printText(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_printTextWithFont:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
float _arg2;
_arg2 = data.readFloat();
woyou.aidlservice.jiuiv5.ICallback _arg3;
_arg3 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.printTextWithFont(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_printColumnsText:
{
data.enforceInterface(descriptor);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
int[] _arg1;
_arg1 = data.createIntArray();
int[] _arg2;
_arg2 = data.createIntArray();
woyou.aidlservice.jiuiv5.ICallback _arg3;
_arg3 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.printColumnsText(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_printBitmap:
{
data.enforceInterface(descriptor);
android.graphics.Bitmap _arg0;
if ((0!=data.readInt())) {
_arg0 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
woyou.aidlservice.jiuiv5.ICallback _arg1;
_arg1 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.printBitmap(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_printBarCode:
{
data.enforceInterface(descriptor);
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
woyou.aidlservice.jiuiv5.ICallback _arg5;
_arg5 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.printBarCode(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_printQRCode:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
woyou.aidlservice.jiuiv5.ICallback _arg3;
_arg3 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.printQRCode(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_printOriginalText:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
woyou.aidlservice.jiuiv5.ICallback _arg1;
_arg1 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.printOriginalText(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_commitPrint:
{
data.enforceInterface(descriptor);
com.refresh.printerhelper.trans.TransBean[] _arg0;
_arg0 = data.createTypedArray(com.refresh.printerhelper.trans.TransBean.CREATOR);
woyou.aidlservice.jiuiv5.ICallback _arg1;
_arg1 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.commitPrint(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_commitPrinterBuffer:
{
data.enforceInterface(descriptor);
this.commitPrinterBuffer();
reply.writeNoException();
return true;
}
case TRANSACTION_enterPrinterBuffer:
{
data.enforceInterface(descriptor);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.enterPrinterBuffer(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_exitPrinterBuffer:
{
data.enforceInterface(descriptor);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.exitPrinterBuffer(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_tax:
{
data.enforceInterface(descriptor);
byte[] _arg0;
_arg0 = data.createByteArray();
woyou.aidlservice.jiuiv5.ITax _arg1;
_arg1 = woyou.aidlservice.jiuiv5.ITax.Stub.asInterface(data.readStrongBinder());
this.tax(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPrinterFactory:
{
data.enforceInterface(descriptor);
woyou.aidlservice.jiuiv5.ICallback _arg0;
_arg0 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.getPrinterFactory(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_clearBuffer:
{
data.enforceInterface(descriptor);
this.clearBuffer();
reply.writeNoException();
return true;
}
case TRANSACTION_commitPrinterBufferWithCallback:
{
data.enforceInterface(descriptor);
woyou.aidlservice.jiuiv5.ICallback _arg0;
_arg0 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.commitPrinterBufferWithCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_exitPrinterBufferWithCallback:
{
data.enforceInterface(descriptor);
boolean _arg0;
_arg0 = (0!=data.readInt());
woyou.aidlservice.jiuiv5.ICallback _arg1;
_arg1 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.exitPrinterBufferWithCallback(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_printColumnsString:
{
data.enforceInterface(descriptor);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
int[] _arg1;
_arg1 = data.createIntArray();
int[] _arg2;
_arg2 = data.createIntArray();
woyou.aidlservice.jiuiv5.ICallback _arg3;
_arg3 = woyou.aidlservice.jiuiv5.ICallback.Stub.asInterface(data.readStrongBinder());
this.printColumnsString(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_updatePrinterState:
{
data.enforceInterface(descriptor);
int _result = this.updatePrinterState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements woyou.aidlservice.jiuiv5.IWoyouService
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
@Override public void updateFirmware() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_updateFirmware, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getFirmwareStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getFirmwareStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getServiceVersion() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getServiceVersion, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void printerInit(woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printerInit, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void printerSelfChecking(woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printerSelfChecking, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String getPrinterSerialNo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPrinterSerialNo, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getPrinterVersion() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPrinterVersion, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getPrinterModal() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPrinterModal, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void getPrintedLength(woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getPrintedLength, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void lineWrap(int n, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(n);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_lineWrap, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void sendRAWData(byte[] data, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(data);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_sendRAWData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void setAlignment(int alignment, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(alignment);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setAlignment, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void setFontName(java.lang.String typeface, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(typeface);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setFontName, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void setFontSize(float fontsize, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeFloat(fontsize);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setFontSize, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void printText(java.lang.String text, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void printTextWithFont(java.lang.String text, java.lang.String typeface, float fontsize, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeString(typeface);
_data.writeFloat(fontsize);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printTextWithFont, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void printColumnsText(java.lang.String[] colsTextArr, int[] colsWidthArr, int[] colsAlign, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(colsTextArr);
_data.writeIntArray(colsWidthArr);
_data.writeIntArray(colsAlign);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printColumnsText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void printBitmap(android.graphics.Bitmap bitmap, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((bitmap!=null)) {
_data.writeInt(1);
bitmap.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printBitmap, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void printBarCode(java.lang.String data, int symbology, int height, int width, int textposition, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(data);
_data.writeInt(symbology);
_data.writeInt(height);
_data.writeInt(width);
_data.writeInt(textposition);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printBarCode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void printQRCode(java.lang.String data, int modulesize, int errorlevel, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(data);
_data.writeInt(modulesize);
_data.writeInt(errorlevel);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printQRCode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void printOriginalText(java.lang.String text, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printOriginalText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void commitPrint(com.refresh.printerhelper.trans.TransBean[] transbean, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedArray(transbean, 0);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_commitPrint, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void commitPrinterBuffer() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_commitPrinterBuffer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void enterPrinterBuffer(boolean clean) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((clean)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_enterPrinterBuffer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void exitPrinterBuffer(boolean commit) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((commit)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_exitPrinterBuffer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void tax(byte[] data, woyou.aidlservice.jiuiv5.ITax callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(data);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_tax, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void getPrinterFactory(woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getPrinterFactory, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void clearBuffer() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_clearBuffer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void commitPrinterBufferWithCallback(woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_commitPrinterBufferWithCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void exitPrinterBufferWithCallback(boolean commit, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((commit)?(1):(0)));
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_exitPrinterBufferWithCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void printColumnsString(java.lang.String[] colsTextArr, int[] colsWidthArr, int[] colsAlign, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(colsTextArr);
_data.writeIntArray(colsWidthArr);
_data.writeIntArray(colsAlign);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printColumnsString, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int updatePrinterState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_updatePrinterState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_updateFirmware = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getFirmwareStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getServiceVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_printerInit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_printerSelfChecking = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getPrinterSerialNo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_getPrinterVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_getPrinterModal = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_getPrintedLength = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_lineWrap = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_sendRAWData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_setAlignment = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_setFontName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_setFontSize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_printText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_printTextWithFont = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_printColumnsText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_printBitmap = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_printBarCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_printQRCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_printOriginalText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_commitPrint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_commitPrinterBuffer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_enterPrinterBuffer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_exitPrinterBuffer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_tax = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_getPrinterFactory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
static final int TRANSACTION_clearBuffer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
static final int TRANSACTION_commitPrinterBufferWithCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
static final int TRANSACTION_exitPrinterBufferWithCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
static final int TRANSACTION_printColumnsString = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
static final int TRANSACTION_updatePrinterState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
}
public void updateFirmware() throws android.os.RemoteException;
public int getFirmwareStatus() throws android.os.RemoteException;
public java.lang.String getServiceVersion() throws android.os.RemoteException;
public void printerInit(woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void printerSelfChecking(woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public java.lang.String getPrinterSerialNo() throws android.os.RemoteException;
public java.lang.String getPrinterVersion() throws android.os.RemoteException;
public java.lang.String getPrinterModal() throws android.os.RemoteException;
public void getPrintedLength(woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void lineWrap(int n, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void sendRAWData(byte[] data, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void setAlignment(int alignment, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void setFontName(java.lang.String typeface, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void setFontSize(float fontsize, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void printText(java.lang.String text, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void printTextWithFont(java.lang.String text, java.lang.String typeface, float fontsize, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void printColumnsText(java.lang.String[] colsTextArr, int[] colsWidthArr, int[] colsAlign, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void printBitmap(android.graphics.Bitmap bitmap, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void printBarCode(java.lang.String data, int symbology, int height, int width, int textposition, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void printQRCode(java.lang.String data, int modulesize, int errorlevel, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void printOriginalText(java.lang.String text, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void commitPrint(com.refresh.printerhelper.trans.TransBean[] transbean, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void commitPrinterBuffer() throws android.os.RemoteException;
public void enterPrinterBuffer(boolean clean) throws android.os.RemoteException;
public void exitPrinterBuffer(boolean commit) throws android.os.RemoteException;
public void tax(byte[] data, woyou.aidlservice.jiuiv5.ITax callback) throws android.os.RemoteException;
public void getPrinterFactory(woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void clearBuffer() throws android.os.RemoteException;
public void commitPrinterBufferWithCallback(woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void exitPrinterBufferWithCallback(boolean commit, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public void printColumnsString(java.lang.String[] colsTextArr, int[] colsWidthArr, int[] colsAlign, woyou.aidlservice.jiuiv5.ICallback callback) throws android.os.RemoteException;
public int updatePrinterState() throws android.os.RemoteException;
}
