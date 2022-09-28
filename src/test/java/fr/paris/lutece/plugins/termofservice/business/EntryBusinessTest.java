/*
 * Copyright (c) 2002-2022, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *"
 * License 1.0
 */

package fr.paris.lutece.plugins.termofservice.business;

import fr.paris.lutece.test.LuteceTestCase;

import java.util.Optional;


/**
 * This is the business class test for the object Entry
 */
public class EntryBusinessTest extends LuteceTestCase
{
    private static final String TEXT1 = "Text1";
    private static final String TEXT2 = "Text2";
	private static final boolean ACCEPTED1 = true;
    private static final boolean ACCEPTED2 = false;

	/**
	* test Entry
	*/
    public void testBusiness(  )
    {
        // Initialize an object
        Entry entry = new Entry();
        entry.setText( TEXT1 );
        entry.setAccepted( ACCEPTED1 );

        // Create test
        EntryHome.create( entry );
        Optional<Entry> optEntryStored = EntryHome.findByPrimaryKey( entry.getId( ) );
        Entry entryStored = optEntryStored.orElse( new Entry ( ) );
        assertEquals( entryStored.getText( ) , entry.getText( ) );
        assertEquals( entryStored.getAccepted( ) , entry.getAccepted( ) );

        // Update test
        entry.setText( TEXT2 );
        entry.setAccepted( ACCEPTED2 );
        EntryHome.update( entry );
        optEntryStored = EntryHome.findByPrimaryKey( entry.getId( ) );
        entryStored = optEntryStored.orElse( new Entry ( ) );
        
        assertEquals( entryStored.getText( ) , entry.getText( ) );
        assertEquals( entryStored.getAccepted( ) , entry.getAccepted( ) );

        // List test
        EntryHome.getEntrysList( );

        // Delete test
        EntryHome.remove( entry.getId( ) );
        optEntryStored = EntryHome.findByPrimaryKey( entry.getId( ) );
        entryStored = optEntryStored.orElse( null );
        assertNull( entryStored );
        
    }
    
    
     

}