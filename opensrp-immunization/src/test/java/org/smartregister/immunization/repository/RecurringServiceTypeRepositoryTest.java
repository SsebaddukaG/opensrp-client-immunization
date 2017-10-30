package org.smartregister.immunization.repository;

import android.content.ContentValues;

import junit.framework.Assert;

import net.sqlcipher.Cursor;
import net.sqlcipher.MatrixCursor;
import net.sqlcipher.database.SQLiteDatabase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.smartregister.immunization.BaseUnitTest;
import org.smartregister.immunization.domain.ServiceType;
import org.smartregister.repository.Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.spy;

/**
 * Created by onaio on 29/08/2017.
 */

public class RecurringServiceTypeRepositoryTest extends BaseUnitTest {

    @InjectMocks
    private RecurringServiceTypeRepository recurringServiceTypeRepository;

    @Mock
    private Repository repository;

    @Mock
    private SQLiteDatabase sqliteDatabase;

    @Before
    public void setUp() {
        org.mockito.MockitoAnnotations.initMocks(this);
        org.junit.Assert.assertNotNull(recurringServiceTypeRepository);
    }

    @Test
    public void instantiatesSuccessfullyOnConstructorCall() throws Exception {
        RecurringServiceTypeRepository vaccineNameRepository = new RecurringServiceTypeRepository(repository);
        org.junit.Assert.assertNotNull(vaccineNameRepository);
    }

    @Test
    public void createTableCallsExecuteSQLMethod() throws Exception {
        recurringServiceTypeRepository.createTable(sqliteDatabase);
        Mockito.verify(sqliteDatabase, Mockito.times(4)).execSQL(org.mockito.ArgumentMatchers.anyString());
    }

    @Test
    public void addCallsDatabaseDatabaseMethod1TimesInCaseOfNonNullVaccineNullID() throws Exception {
        Mockito.when(recurringServiceTypeRepository.getWritableDatabase()).thenReturn(sqliteDatabase);
        ServiceType serviceType = PowerMockito.mock(ServiceType.class);
        Mockito.when(serviceType.getId()).thenReturn(null);
        recurringServiceTypeRepository.add(serviceType, sqliteDatabase);
        Mockito.verify(sqliteDatabase, Mockito.times(1)).insert(org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.isNull(String.class), any(ContentValues.class));
    }

    @Test
    public void searchByNamecallsDatabaseQueryMethod1Times() throws Exception {
        String[] columns = new String[] {RecurringServiceTypeRepository.ID_COLUMN,RecurringServiceTypeRepository.NAME,RecurringServiceTypeRepository.TYPE,RecurringServiceTypeRepository.SERVICE_NAME_ENTITY,RecurringServiceTypeRepository.SERVICE_NAME_ENTITY_ID,RecurringServiceTypeRepository.DATE_ENTITY,RecurringServiceTypeRepository.DATE_ENTITY_ID,RecurringServiceTypeRepository.UNITS,RecurringServiceTypeRepository.SERVICE_LOGIC,RecurringServiceTypeRepository.PREREQUISITE,RecurringServiceTypeRepository.PRE_OFFSET,RecurringServiceTypeRepository.EXPIRY_OFFSET,RecurringServiceTypeRepository.MILESTONE_OFFSET,RecurringServiceTypeRepository.UPDATED_AT_COLUMN};
        MatrixCursor cursor= new MatrixCursor(columns);
        cursor.addRow(new Object[] { 1l, "","","","","","","","","","","","",1l});
        Mockito.when(sqliteDatabase.query(org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class))).thenReturn(cursor);
        Mockito.when(recurringServiceTypeRepository.getReadableDatabase()).thenReturn(sqliteDatabase);
        recurringServiceTypeRepository.searchByName("Name");
        Mockito.verify(sqliteDatabase, Mockito.times(1)).query(org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class));
        Assert.assertNotNull(recurringServiceTypeRepository.searchByName(""));
    }

    @Test
    public void searchByTypecallsDatabaseQueryMethod1Times() throws Exception {
        String[] columns = new String[] {RecurringServiceTypeRepository.ID_COLUMN,RecurringServiceTypeRepository.NAME,RecurringServiceTypeRepository.TYPE,RecurringServiceTypeRepository.SERVICE_NAME_ENTITY,RecurringServiceTypeRepository.SERVICE_NAME_ENTITY_ID,RecurringServiceTypeRepository.DATE_ENTITY,RecurringServiceTypeRepository.DATE_ENTITY_ID,RecurringServiceTypeRepository.UNITS,RecurringServiceTypeRepository.SERVICE_LOGIC,RecurringServiceTypeRepository.PREREQUISITE,RecurringServiceTypeRepository.PRE_OFFSET,RecurringServiceTypeRepository.EXPIRY_OFFSET,RecurringServiceTypeRepository.MILESTONE_OFFSET,RecurringServiceTypeRepository.UPDATED_AT_COLUMN};
        MatrixCursor cursor= new MatrixCursor(columns);
        cursor.addRow(new Object[] { 1l, "","","","","","","","","","","","",1l});
        Mockito.when(sqliteDatabase.query(org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class))).thenReturn(cursor);
        Mockito.when(recurringServiceTypeRepository.getReadableDatabase()).thenReturn(sqliteDatabase);
        recurringServiceTypeRepository.findByType("Type");
        Mockito.verify(sqliteDatabase, Mockito.times(1)).query(org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class));
        Assert.assertNotNull(recurringServiceTypeRepository.findByType(""));
    }

    @Test
    public void findcallsDatabaseQueryMethod1Times() throws Exception {
        String[] columns = new String[] {RecurringServiceTypeRepository.ID_COLUMN,RecurringServiceTypeRepository.NAME,RecurringServiceTypeRepository.TYPE,RecurringServiceTypeRepository.SERVICE_NAME_ENTITY,RecurringServiceTypeRepository.SERVICE_NAME_ENTITY_ID,RecurringServiceTypeRepository.DATE_ENTITY,RecurringServiceTypeRepository.DATE_ENTITY_ID,RecurringServiceTypeRepository.UNITS,RecurringServiceTypeRepository.SERVICE_LOGIC,RecurringServiceTypeRepository.PREREQUISITE,RecurringServiceTypeRepository.PRE_OFFSET,RecurringServiceTypeRepository.EXPIRY_OFFSET,RecurringServiceTypeRepository.MILESTONE_OFFSET,RecurringServiceTypeRepository.UPDATED_AT_COLUMN};
        MatrixCursor cursor= new MatrixCursor(columns);
        cursor.addRow(new Object[] { 1l, "","","","","","","","","","","","",1l});

        Mockito.when(sqliteDatabase.query(org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class))).thenReturn(cursor);
        Mockito.when(recurringServiceTypeRepository.getReadableDatabase()).thenReturn(sqliteDatabase);
        recurringServiceTypeRepository.find(1l, sqliteDatabase);
        Mockito.verify(sqliteDatabase, Mockito.times(1)).query(org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class));
    }

    @Test
    public void addCallsDatabaseDatabaseMethod0TimesInCaseOfNullVaccine() throws Exception {
        recurringServiceTypeRepository.add(null, sqliteDatabase);
        Mockito.verify(sqliteDatabase, Mockito.times(0)).insert(org.mockito.ArgumentMatchers.anyString(), (String) org.mockito.ArgumentMatchers.isNull(), any(ContentValues.class));
        Mockito.verify(sqliteDatabase, Mockito.times(0)).update(org.mockito.ArgumentMatchers.anyString(), any(ContentValues.class), org.mockito.ArgumentMatchers.anyString(), any(String[].class));

        ServiceType serviceType = new ServiceType();
        serviceType.setId(1l);
        RecurringServiceTypeRepository spy = spy(recurringServiceTypeRepository);
        Mockito.doReturn(serviceType).when(spy).find(anyLong(),any(SQLiteDatabase.class));
        spy.add(serviceType);
        Mockito.verify(sqliteDatabase, Mockito.times(0)).update(org.mockito.ArgumentMatchers.anyString(), any(ContentValues.class), org.mockito.ArgumentMatchers.anyString(), any(String[].class));
        Assert.assertNull(recurringServiceTypeRepository.find(0l));
    }

    @Test
    public void fetchAllTypecallsDatabaseQueryMethod1Times() throws Exception {

        String[] columns = new String[] {RecurringServiceTypeRepository.ID_COLUMN,RecurringServiceTypeRepository.NAME,RecurringServiceTypeRepository.TYPE,RecurringServiceTypeRepository.SERVICE_NAME_ENTITY,RecurringServiceTypeRepository.SERVICE_NAME_ENTITY_ID,RecurringServiceTypeRepository.DATE_ENTITY,RecurringServiceTypeRepository.DATE_ENTITY_ID,RecurringServiceTypeRepository.UNITS,RecurringServiceTypeRepository.SERVICE_LOGIC,RecurringServiceTypeRepository.PREREQUISITE,RecurringServiceTypeRepository.PRE_OFFSET,RecurringServiceTypeRepository.EXPIRY_OFFSET,RecurringServiceTypeRepository.MILESTONE_OFFSET,RecurringServiceTypeRepository.UPDATED_AT_COLUMN};
        MatrixCursor cursor= new MatrixCursor(columns);
        cursor.addRow(new Object[] { 1l, "","","","","","","","","","","","",1l});
        cursor.addRow(new Object[] { 1l, "","a_b","","","","","","","","","","",1l});

        Mockito.when(sqliteDatabase.query(org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String[].class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.anyString())).thenReturn(cursor);
        Mockito.when(recurringServiceTypeRepository.getReadableDatabase()).thenReturn(sqliteDatabase);
        recurringServiceTypeRepository.fetchAll();
        Mockito.verify(sqliteDatabase, Mockito.times(1)).query(org.mockito.ArgumentMatchers.anyString(), any(String[].class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String[].class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.isNull(String.class), org.mockito.ArgumentMatchers.anyString());
    }

    @Test
    public void fetchTypescallsDatabaseQueryMethod1Times() throws Exception {
        String[] columns = new String[] {RecurringServiceTypeRepository.ID_COLUMN,RecurringServiceTypeRepository.NAME,RecurringServiceTypeRepository.TYPE,RecurringServiceTypeRepository.SERVICE_NAME_ENTITY,RecurringServiceTypeRepository.SERVICE_NAME_ENTITY_ID,RecurringServiceTypeRepository.DATE_ENTITY,RecurringServiceTypeRepository.DATE_ENTITY_ID,RecurringServiceTypeRepository.UNITS,RecurringServiceTypeRepository.SERVICE_LOGIC,RecurringServiceTypeRepository.PREREQUISITE,RecurringServiceTypeRepository.PRE_OFFSET,RecurringServiceTypeRepository.EXPIRY_OFFSET,RecurringServiceTypeRepository.MILESTONE_OFFSET,RecurringServiceTypeRepository.UPDATED_AT_COLUMN};
        MatrixCursor cursor= new MatrixCursor(columns);
        cursor.addRow(new Object[] { 1l, "","","","","","","","","","","","",1l});

        Mockito.when(sqliteDatabase.rawQuery(org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.isNull(String[].class))).thenReturn(cursor);
        Mockito.when(recurringServiceTypeRepository.getReadableDatabase()).thenReturn(sqliteDatabase);
        recurringServiceTypeRepository.fetchTypes();
        Mockito.verify(sqliteDatabase, Mockito.times(1)).rawQuery(org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.isNull(String[].class));
    }

    @Test
    public void deletecallsDatabaseDeleteMethod1Times() throws Exception {
        RecurringServiceTypeRepository recurringServiceTypeRepositoryspy = spy(recurringServiceTypeRepository);
        ServiceType serviceType = new ServiceType();
        Mockito.doReturn(serviceType).when(recurringServiceTypeRepositoryspy).find(0l, null);
        Mockito.when(recurringServiceTypeRepositoryspy.getWritableDatabase()).thenReturn(sqliteDatabase);
        recurringServiceTypeRepositoryspy.deleteServiceType(0l);
        Mockito.verify(sqliteDatabase, Mockito.times(1)).delete(org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyString(), any(String[].class));
    }

    @Test
    public void addHyphenMethodWithBlankParamReturnsBlankString() throws Exception {
        String testString = recurringServiceTypeRepository.addHyphen("");
        org.junit.Assert.assertNotNull(testString);
        org.junit.Assert.assertTrue(testString.isEmpty());
    }

    @Test
    public void removeHyphenMethodWithBlankParamReturnsBlankString() throws Exception {
        String testString = recurringServiceTypeRepository.removeHyphen("");
        org.junit.Assert.assertNotNull(testString);
        org.junit.Assert.assertTrue(testString.isEmpty());
    }

}
