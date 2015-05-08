/**
 * CatalogServicesImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uno.vendor.service;

public class CatalogServicesImplServiceLocator extends org.apache.axis.client.Service implements uno.vendor.service.CatalogServicesImplService {

    public CatalogServicesImplServiceLocator() {
    }


    public CatalogServicesImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CatalogServicesImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CatalogServicesImplPort
    private java.lang.String CatalogServicesImplPort_address = "http://localhost:8080/Training_Vendor_Service/CatalogServicesImplService";

    public java.lang.String getCatalogServicesImplPortAddress() {
        return CatalogServicesImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CatalogServicesImplPortWSDDServiceName = "CatalogServicesImplPort";

    public java.lang.String getCatalogServicesImplPortWSDDServiceName() {
        return CatalogServicesImplPortWSDDServiceName;
    }

    public void setCatalogServicesImplPortWSDDServiceName(java.lang.String name) {
        CatalogServicesImplPortWSDDServiceName = name;
    }

    public uno.vendor.service.CatalogServicesImpl getCatalogServicesImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CatalogServicesImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCatalogServicesImplPort(endpoint);
    }

    public uno.vendor.service.CatalogServicesImpl getCatalogServicesImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uno.vendor.service.CatalogServicesImplPortBindingStub _stub = new uno.vendor.service.CatalogServicesImplPortBindingStub(portAddress, this);
            _stub.setPortName(getCatalogServicesImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCatalogServicesImplPortEndpointAddress(java.lang.String address) {
        CatalogServicesImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uno.vendor.service.CatalogServicesImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                uno.vendor.service.CatalogServicesImplPortBindingStub _stub = new uno.vendor.service.CatalogServicesImplPortBindingStub(new java.net.URL(CatalogServicesImplPort_address), this);
                _stub.setPortName(getCatalogServicesImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CatalogServicesImplPort".equals(inputPortName)) {
            return getCatalogServicesImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.vendor.uno/", "CatalogServicesImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.vendor.uno/", "CatalogServicesImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CatalogServicesImplPort".equals(portName)) {
            setCatalogServicesImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
