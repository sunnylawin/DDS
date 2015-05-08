/**
 * PositionSkillMgmtService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uno.personnel.service;

public interface PositionSkillMgmtService extends java.rmi.Remote {
    public java.lang.String addJob(java.lang.String arg0, int arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public java.lang.String addSkill(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String addJobSkill(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String dropJobSkill(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.Object[] positionSkill(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.Object[] possiblePosition(java.lang.String arg0) throws java.rmi.RemoteException;
}
