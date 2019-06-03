/*
 * Copyright 2006 Niclas Hedhman.
 *
 * Licensed  under the  Apache License,  Version 2.0  (the "License");
 * you may not use  this file  except in  compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed  under the  License is distributed on an "AS IS" BASIS,
 * WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.logging.internal;

import org.apache.commons.logging.Log;
import org.osgi.framework.BundleContext;
import org.ops4j.pax.logging.PaxLogger;
import org.ops4j.pax.logging.PaxLoggingManager;

public class JclLogger
    implements Log
{

    public static final String JCL_FQCN = JclLogger.class.getName();
    
    private PaxLogger m_delegate;

    public JclLogger( PaxLogger delegate )
    {
        m_delegate = delegate;
    }

    public boolean isDebugEnabled()
    {
        return m_delegate.isDebugEnabled();
    }

    public boolean isErrorEnabled()
    {
        return m_delegate.isErrorEnabled();
    }

    public boolean isFatalEnabled()
    {
        return m_delegate.isFatalEnabled();
    }

    public boolean isInfoEnabled()
    {
        return m_delegate.isInfoEnabled();
    }

    public boolean isTraceEnabled()
    {
        return m_delegate.isTraceEnabled();
    }

    public boolean isWarnEnabled()
    {
        return m_delegate.isWarnEnabled();
    }

    public void trace( Object message )
    {
        if( m_delegate.isTraceEnabled() && message != null )
        {
            m_delegate.trace( message.toString(), (Throwable) null );
        }
    }

    public void trace( Object message, Throwable t )
    {
      if (m_delegate.isTraceEnabled()) {

        if( message != null )
        {
            m_delegate.trace( message.toString(), t );
        }
        else
        {
            m_delegate.trace( null, t );
        }
      }
    }

    public void debug( Object message )
    {
        if( m_delegate.isDebugEnabled() && message != null )
        {
            m_delegate.debug( message.toString(), (Throwable) null );
        }
    }

    public void debug( Object message, Throwable t )
    {
      if (m_delegate.isDebugEnabled()) {

        if( message != null )
        {
            m_delegate.debug( message.toString(), t );
        }
        else
        {
            m_delegate.debug( null, t );
        }
      }
    }

    public void info( Object message )
    {
        if( m_delegate.isInfoEnabled() && message != null )
        {
            m_delegate.inform( message.toString(), null );
        }
    }

    public void info( Object message, Throwable t )
    {
      if (m_delegate.isInfoEnabled()) {

        if( message != null )
        {
            m_delegate.inform( message.toString(), t );
        }
        else
        {
            m_delegate.inform( null, t );
        }
      }

    }

    public void warn( Object message )
    {
        if( m_delegate.isWarnEnabled() && message != null )
        {
            m_delegate.warn( message.toString(), (Throwable) null );
        }
    }

    public void warn( Object message, Throwable t )
    {
      if (m_delegate.isWarnEnabled()) {
        if( message != null )
        {
            m_delegate.warn( message.toString(), t );
        }
        else
        {
            m_delegate.warn( null, t );
        }
      }
    }

    public void error( Object message )
    {
        if( m_delegate.isErrorEnabled() && message != null )
        {
            m_delegate.error( message.toString(), (Throwable) null );
        }

    }

    public void error( Object message, Throwable t )
    {
      if (m_delegate.isErrorEnabled()) {
        if( message != null )
        {
            m_delegate.error( message.toString(), t );
        }
        else
        {
            m_delegate.error( null, t );
        }
      }
    }

    public void fatal( Object message )
    {
        if( m_delegate.isFatalEnabled() && message != null )
        {
            m_delegate.fatal( message.toString(), null );
        }
    }

    public void fatal( Object message, Throwable t )
    {
      if (m_delegate.isFatalEnabled()) {

        if( message != null )
        {
            m_delegate.fatal( message.toString(), t );
        }
        else
        {
            m_delegate.fatal( null, t );
        }
      }
    }

    public int getLogLevel()
    {
        return m_delegate.getLogLevel();
    }

    public void setBundleContext( BundleContext context )
    {
    }

    /**
     * Not a public method.
     *
     * @param paxLoggingManager TODO
     * @param name TODO
     */
    public void setPaxLoggingManager( PaxLoggingManager paxLoggingManager, String name )
    {
        m_delegate = paxLoggingManager.getLogger( name, JCL_FQCN );
    }
}
