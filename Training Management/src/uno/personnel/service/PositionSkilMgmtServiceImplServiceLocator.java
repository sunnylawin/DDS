/**
 * PositionSkilMgmtServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uno.personnel.service;

public class PositionSkilMgmtServiceImplServiceLocator extends org.apache.axis.client.Service implements uno.personnel.service.PositionSkilMgmtServiceImplService {

    public PositionSkilMgmtServiceImplServiceLocator() {
    }


    public PositionSkilMgmtServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PositionSkilMgmtServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PositionSkillMgmtServicePort
    private java.lang.String PositionSkillMgmtServicePort_address = "http://localhost:8080/Personal_Information_System/PositionSkilMgmtServiceImplService";

    public java.lang.String getPositionSkillMgmtServicePortAddress() {
        return PositionSkillMgmtServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PositionSkillMgmtServicePortWSDDServiceName = "PositionSkillMgmtServicePort";

    public java.lang.String getPositionSkillMgmtServicePortWSDDServiceName() {
        return PositionSkillMgmtServicePortWSDDServiceName;
    }

    public void setPositionSkillMgmtServicePortWSDDServiceName(java.lang.String name) {
        PositionSkillMgmtServicePortWSDDServiceName = name;
    }

    public uno.personnel.service.PositionSkillMgmtService getPositionSkillMgmtServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PositionSkillMgmtServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPositionSkillMgmtServicePort(endpoint);
    }

    public uno.personnel.service.PositionSkillMgmtService getPositionSkillMgmtServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uno.personnel.service.PositionSkillMgmtServicePortBindingStub _stub = new uno.personnel.service.PositionSkillMgmtServicePortBindingStub(portAddress, this);
            _stub.setPortName(getPositionSkillMgmtServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPositionSkillMgmtServicePortEndpointAddress(java.lang.String address) {
        PositionSkillMgmtServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uno.personnel.service.PositionSkillMgmtService.class.isAssignableFrom(serviceEndpointInterface)) {
                uno.personnel.service.PositionSkillMgmtServicePortBindingStub _stub = new uno.personnel.service.PositionSkillMgmtServicePortBindingStub(new java.net.URL(PositionSkillMgmtServicePort_address), this);
                _stub.setPortName(getPositionSkillMgmtServicePortWSDDServiceName());
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
        if ("PositionSkillMgmtServicePort".equals(inputPortName)) {
            return getPositionSkillMgmtServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.personnel.uno/", "PositionSkilMgmtServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.personnel.uno/", "PositionSkillMgmtServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PositionSkillMgmtServicePort".equals(portName)) {
            setPositionSkillMgmtServicePortEndpointAddress(address);
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
