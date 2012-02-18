package com.test.growl;

import net.sf.libgrowl.Application;
import net.sf.libgrowl.GrowlConnector;
import net.sf.libgrowl.Notification;
import net.sf.libgrowl.NotificationType;
import net.sf.libgrowl.internal.IProtocol;


public class GrowlSample {
	// Main function executed
		public static void main(String[] args) throws Exception {
			
			/*
			 * member variables
			 */
			String name = "HelloGrowl";
			String notificationTypeId = "growlNotify";
			boolean sticky = false;
			String iconUrl = null;
			String message = "hello growl";
			int priority = 0;
			String host = "localhost";
			int port = IProtocol.DEFAULT_GROWL_PORT;
			String title = "HELLO";
			
			/*
			 * initialize
			 */
			GrowlConnector growl = new GrowlConnector(host, port);
			Application application = new Application(name);
			NotificationType notificationType = new NotificationType(notificationTypeId, name, iconUrl);
			NotificationType[] notificationTypes = new NotificationType[] { notificationType };
			
			/*
			 *  register  
			 */
			growl.register(application, notificationTypes);			
			
			/*
			 * send notify
			 */
			Notification notification = new Notification(application, notificationType, title, message);
			notification.setPriority(priority);
			notification.setSticky(sticky);
			growl.notify(notification);
		}
}
