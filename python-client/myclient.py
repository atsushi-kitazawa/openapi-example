import time
import openapi_client
from pprint import pprint
from openapi_client.api import default_api
# Defining the host is optional and defaults to http://api.example.com/v1
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:8080/myapp"
)

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration, header_name="Accept", header_value="application/*") as api_client:
    # Create an instance of the API class
    api_instance = default_api.DefaultApi(api_client)
    
    try:
        api_response = api_instance.users_get()
        pprint(api_response)

        api_response = api_instance.users_user_id_get(1)
        pprint(api_response)

        api_response = api_instance.download("download_file")
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling DefaultApi: %s\n" % e)