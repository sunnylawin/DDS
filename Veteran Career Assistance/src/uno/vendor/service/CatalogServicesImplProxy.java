package uno.vendor.service;

public class CatalogServicesImplProxy implements uno.vendor.service.CatalogServicesImpl {
  private String _endpoint = null;
  private uno.vendor.service.CatalogServicesImpl catalogServicesImpl = null;
  
  public CatalogServicesImplProxy() {
    _initCatalogServicesImplProxy();
  }
  
  public CatalogServicesImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initCatalogServicesImplProxy();
  }
  
  private void _initCatalogServicesImplProxy() {
    try {
      catalogServicesImpl = (new uno.vendor.service.CatalogServicesImplServiceLocator()).getCatalogServicesImplPort();
      if (catalogServicesImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)catalogServicesImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)catalogServicesImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (catalogServicesImpl != null)
      ((javax.xml.rpc.Stub)catalogServicesImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uno.vendor.service.CatalogServicesImpl getCatalogServicesImpl() {
    if (catalogServicesImpl == null)
      _initCatalogServicesImplProxy();
    return catalogServicesImpl;
  }
  
  public uno.vendor.service.CourseInfoVO recommendCourse(java.lang.String arg0) throws java.rmi.RemoteException{
    if (catalogServicesImpl == null)
      _initCatalogServicesImplProxy();
    return catalogServicesImpl.recommendCourse(arg0);
  }
  
  public uno.vendor.service.CourseInfoVO courseInfo(java.lang.String arg0) throws java.rmi.RemoteException{
    if (catalogServicesImpl == null)
      _initCatalogServicesImplProxy();
    return catalogServicesImpl.courseInfo(arg0);
  }
  
  public java.lang.Object[] areaCall(java.lang.String arg0) throws java.rmi.RemoteException{
    if (catalogServicesImpl == null)
      _initCatalogServicesImplProxy();
    return catalogServicesImpl.areaCall(arg0);
  }
  
  
}